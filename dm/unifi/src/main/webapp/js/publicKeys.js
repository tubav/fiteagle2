define(['require','utils','server','validation','messages','fileSaver'],
/**
 * @lends MainPage
 */ 
function(require,Utils,Server,Validation,Messages){
	
	/** 
     * PublicKeys class
     * The PublicKey class contains functions required for the user public key management.
     * @class
     * @constructor
     * @return PublicKeys object
     */
	PublicKeys = {};
	
	
	/**
	* Triggers public keys form initialization for existing and new user keys.
	* @public
	* @name PublicKeys#initForm
	* @function
	**/
	PublicKeys.initForm = function(){
		initExistingPublicKeysForm();
		initNewUserKeysForm();
	};
	
	
	/**
      * Triggers new user public keys form initialization for file selection, form field description and public key upload functions 
	  * @private
	  * @memberOf PublicKeys#
     */ 
	initNewUserKeysForm = function(){
		checkFileSelectSupport();
		initTooltipForKeyDescriptionField();
		initTooltipForPublicKeyFromFile();
		initUploadPublicKeyBtn();
		$('#publicKeyFromFile').on('click',function(){
			$(this).find('textarea').removeAttr('disabled').focus();
		});
	};
	
	
	/**
      * Initializes the behaviour after clicking on the upload public key button defined by '#uploadNewPublicKey' selector. 
	  * It performs removing of the previous error messages shown to the user before, checking for valid key description.
	  * Uploads the new public key to the server. Shows error messages to the user received from the server if something went wrong.
	  * @private
	  * @memberOf PublicKeys#
     */ 
	initUploadPublicKeyBtn = function(){
		$('#uploadNewPublicKey').on('click',function(){
			clearPublicKeysErrors();
			var isKeyDescrValid = isKeyDescriptionValid();
			var isKeyValValid = isKeyValueValid()
			if( isKeyDescrValid && isKeyValValid ){
				//clearPublicKeysErrors();
				var description = $("#inputKeyDescription").val();
				var publicKeyString = $('#publicKeyFromFile textarea').val();
				publicKey = createNewPublicKeyObject(description,publicKeyString);
				var message;
				setTimeout(function(){
					message = Server.uploadNewPublicKey(publicKey, "#uploadingSing");
					if(message)
						$('#newUserKeyErrors').append(message);
					updatePublicKeyRelatedForms();
				},100)

			}
		}).tooltip({title: Messages.uploadNewPublicKey});
	};
	
	/**
      * Checks if the support for the file selection is available for the given system.
	  * @return true if file select support is available false otherwise
	  * @private
	  * @memberOf PublicKeys#
     */
	checkFileSelectSupport = function(){
		if(isFileSelectAvailable()){
			initFileSelectBtn();
		}else{
			disableUploadNewUserKeysForm();
		}
	};
	
	
	/**
	* Triggers update procedure for the all form related to the public key. It is needed e.g. in case public key is uploaded or removed to
	* update the values in the appropriate fields such as select boxes etc.
    * @private
	* @memberOf PublicKeys#
	*/
	updatePublicKeyRelatedForms = function(){	
		initExistingPublicKeysForm();
		Certificates.initPublicKeySelect();
		resetSelectedFileInfo();
	};
	
	/**
	* Disables container for file selection and uploading, it is used if the system has no support for file selection.
	* The container receives information message, that the file selection is not supported.
    * @private
	* @memberOf PublicKeys#
	*/
	disableUploadNewUserKeysForm = function(){
		var info = $('<span>')
			.addClass("alert alert-info span8")
			.append(Messages.fileSelectionNotSupported);
			
		$('#uploadNewUserKeysContainer').children().remove();
		$('#uploadNewUserKeysContainer').append(info);
	};
	
	/**
	* Checks if the file selection is available on the system
	* @return true if file selection is available and false otherwise
    * @private
	* @memberOf PublicKeys#
	*/
	isFileSelectAvailable = function(){
		var isAvailable;
		(window.File && window.FileReader && 
			window.FileList && window.Blob)?
				isAvailable = true
					:
				isAvailable = false

		return isAvailable;
	};
	
	/**
	* Initiates Twitter Bootstrap tooltip for public key description field. Placed on the top for small devices and on the right side for the large ones.
    * @private
	* @memberOf PublicKeys#
	*/
	initTooltipForKeyDescriptionField = function(){		
		var placement;								
		(Utils.isSmallScreen())? placement="top": placement = "right";												
		Utils.initTooltipFor(
				"#inputKeyDescription",
				Messages.keyDescription,
				placement,
				"focus");
	};

	/**
	* Creates new public key object in the format that can be converted to json and send to the server via AJAX request.
	* @param   {String} description of the public key 
	* @param   {String} key_string is a public key value
	* @return  public key object
    * @private
	* @memberOf PublicKeys#
	*/
	createNewPublicKeyObject = function(description,keyString){
		var publicKey = new Object();
		publicKey.publicKeyString = keyString;
		publicKey.description = description;
		//console.log(JSON.stringify(publicKey));
		return publicKey;
	};
	

	/**
	*	Triggers file select button initialization: the behaviour after click, or file selection is performed.
    * @private
	* @memberOf PublicKeys#
	*/
	initFileSelectBtn = function(){
		initSelectFileInput();
		$('#selectFromFile').on('click',function(){
			$('#selectFromFileInput input').click();
		});
	/*
		fileSelectForm.on('click',function(){
			this.value = null;
		});*/

	};
	
	initSelectFileInput = function(){
			var inputFileContainer = $('#selectFromFileInput');
			inputFileContainer.children().remove();
			var fileSelect = $('<input>')
								.attr('type','file')
								.attr('name','file')
								.on('change',function(event){
										//console.log(event);
										clearPublicKeysErrors();
										handleFileSelect(event);
										setTimeout(function(){
											initSelectFileInput();
										},200)
								});
			inputFileContainer.append(fileSelect);
	};
	
	
	/**
	* Checks if the public key description string provided by a user in a form identified by "#inputKeyDescription" selector is a valid one.
	* The validation is performed by the function called "Validation._isKeyName()" located in the validation.js module.
	* Error messages can be found in the module messages.js
    * @return true if public key description field is valid one, otherwise false is returned.
    * @private
	* @memberOf PublicKeys#	
	*/
	isKeyDescriptionValid = function(){
		var isValidDescription = Utils.checkInputField(
								"#inputKeyDescription",
								"#newUserKeyErrors",
								Validation._isKeyName,
								Messages.emptyKeyDescription,
								Messages.wrongKeyDescription);
								
		return isValidDescription;
	};
	
	
	/**
	* Checks if the public key value provided by a user in a form identified by "#publicKeyFromFile textarea" selector is a valid one.
	* The validation is performed by the function called "Validation._isKeyValue()" located in the validation.js module.
	* Error messages can be found in the module messages.js
    * @private
	* @memberOf PublicKeys#
	*/
	isKeyValueValid = function(){
		var isValidKeyValue = Utils.checkInputField(
								"#publicKeyFromFile textarea",
								"#newUserKeyErrors",
								Validation._isKeyValue,
								Messages.emptyKeyValue,
								Messages.wrongKeyValue);						
		return isValidKeyValue;
	};
	
	
	/**
	* Triggers the procedures for the form initialization called "Existing user keys".
	* The function analyses the current user profile and creates for each public key one entry for representing to the user.
	* The form contains public key description, key value, download and remove key buttons.
    * @private
	* @memberOf PublicKeys#
	*/
	initExistingPublicKeysForm = function(){
		user = Utils.getCurrentUser();
		$('#publicKeysList').children().remove();
		username = user.username;
		var publicKeys = user.publicKeys;
		if(publicKeys.length > 0){	
			for(var i = 0; i < publicKeys.length; i++ ){
				var newItem  = createNewPublicKeysListItem(publicKeys[i], i);
				$("#publicKeysList").append(newItem);
			}
		}else{
			var info = $('<span>').addClass('alert alert-info .noPublicKey span8').text(Messages.noPublicKeys);
			$("#publicKeysList").append(info);
		}
	};
	
	/**
	* Triggers updating for only the existing public key form container. The function re-initiate the public key items creation.
    * @private
	* @memberOf PublicKeys#
	*/
	PublicKeys.updateExistingPublicKeyForm = function(){
		var userFromServer = Server.getUser(Utils.getCurrentUser().username);
		initExistingPublicKeysForm(userFromServer)
	};
	
	
	/**
      * Creates new public key item container to be shown  in the section "Existing User Keys".
	  * The container contains key description label and key value textfield as well as download and remove buttons for
	  * managing of the key.
	  * The function triggers behaviour initialisation for editing of the public key description, download and key removal.
	  * @return public key item container
	  * @private
	  * @memberOf PublicKeys#
     */
	createNewPublicKeysListItem = function(publicKey, itemNumber){
		var keyDescription = publicKey.description;
		var keyString = publicKey.publicKeyString;
		var div = $("<div>").addClass('row-fluid publicKey');
		var label = initPublicKeyLabel('pubKeyDescriptionLabel'+itemNumber,keyDescription);

		var d = $('<div>').addClass('span8');
		var textArea =$('<textarea style="resize:none" class="span12" rows="6"  disabled ></textarea>')
						.val(keyString)
						.attr('id','publicKeyTextArea'+itemNumber);
						
		d.append(textArea);
		
		//				$('#publicKeyTextArea'+i).on('click',function(){console.log('dfdsgsdfgsdfgadfg')});
		d.on('click',function(){
			//$('#publicKeyTextArea'+itemNumber).removeAttr('disabled');
			
		});	
		var keyContols = $('<div>')
						.attr('id',"publicKeyControls")
						.addClass('span2 pull-right');
						
		var downloadBtn = createPublicKeyDownloadBtn(keyDescription,keyString);
		
		var deleteKey = $('<button>')
							.attr('data-number',itemNumber)
							.addClass('btn btn-inverse span5 offset2 ')
							.html('<i class="icon-remove icon-large nopadding"></i>');
							
		deleteKey.tooltip({'title':"Remove", 'placement':'top'});
							
		deleteKey.on('click',function(event){
			onDeleteKeyPressed(keyDescription);
		});					
		
		keyContols.append(downloadBtn);
		keyContols.append(deleteKey);
		
		div.append(label);
		div.append(d);
		div.append(keyContols);
		
		return div;
		
	};
	
	
	/**
	* Creates and initializes the public key label within the existing public key item. Defines on click functionality and triggers 
	* twitter bootstrap tooltip on hover event.
	* Tooltip message can be seen and altered in the messages.js module.
	* @return public key label object.
    * @private
	* @memberOf PublicKeys#
	*/
	initPublicKeyLabel =function(keyLabelID, keyDescription){
		var label = $('<label class="span2" ></label>')
					.attr('id',keyLabelID)
					.html('<b>Public key: </b><span class="keyDescriptionSpan">' + keyDescription+'</span>');
		label.tooltip({
				'title': Messages.clickToChangeKeyDescription	
			});
		label.on('click',function(e){
			var oldKey = $(this).find('.keyDescriptionSpan').text();
			onPublicKeyLabelClick(keyLabelID)
		});
		
		return label;
	};
	
	
	/**
	* Defines the behaviour after the user clicks on the public key label in the "existing public key" form.
    * @private
	* @memberOf PublicKeys#
	*/
	onPublicKeyLabelClick = function(keyLabelID){
	    var submitBtnID = 'submitNewKeyDescriptionBtn';
		var errContainerID = 'newPublicKeydescriptionError';
		var inputFieldID = 'changePublicKeyDescriptionField';
		var modal = createSubmitNewPublicKeyDescriptionModal(submitBtnID,errContainerID,inputFieldID);
		modal.find('#'+submitBtnID).on('click',function(){
			Utils.clearErrorMessagesFrom('#'+errContainerID);				
			var isValidNewKeyDescription = Utils.checkInputField(
								'#'+inputFieldID,
								'#'+errContainerID,
								Validation._isKeyName,
								Messages.emptyKeyDescription,
								Messages.wrongKeyDescription);
			if(isValidNewKeyDescription){
				var newKey = $('#'+inputFieldID).val();
				var oldKey = $('#'+keyLabelID).find('.keyDescriptionSpan').text();
				var msg = Server.renamePublicKey(oldKey,newKey); //TODO
				var isSuccessMsg = msg.find('span').hasClass('alert-success');
				if(isSuccessMsg){ 
					Utils.showSuccessModal(msg);
					modal.modal('hide');
				}else{
					$('#'+errContainerID).append(msg);
				}			
				updatePublicKeyRelatedForms();
			}
		});
		
		$('body').append(modal);
		Utils.addOnEnterClickEvent('#'+inputFieldID,'#'+submitBtnID);
		modal.modal('show');
	};
	
	
	/**
	* Creates twitter bootstap modal is used for submitting a new public key description.
	* The modal body contains input field for providing a new public value.
	* The modal footer has the "Submit" and "Cancel" buttons.
	* @param {String} submit_button_id is an identifier for the submit button
 	* @param {String} error_container_field_id is an identifier for the error container within the modal body
	* @param {String} input_field_id is an identifier for the new public key description input field
	* @return {Object} submit new public key modal object that can be append to body and shown to the user
    * @private
	* @memberOf PublicKeys#
	*/
	createSubmitNewPublicKeyDescriptionModal = function(submitBtnID,errorContainerID, inputFieldID){
	
		var modBody = $('<div>').addClass('modal-body centered')
		.append(
			$('<h5>').addClass('centered').text(Messages.newKeyDescription)
		)
		.append(
			$('<div>').attr('id',errorContainerID).addClass('row-fluid')
		)
		.append(
			$('<div>').addClass('row-fluid top20').append(
				$('<label>').attr('for',inputFieldID).addClass('span5').text('New Public Key Description')
			).append(
				$('<input type="text" required></input>')
					.attr('id',inputFieldID).addClass('span7')
					.tooltip({trigger: 'focus',title: Messages.newKeyDescription})
			)
		);
		return Utils.createConfirmModal('changePublicKeyDescriptionModal',submitBtnID,'Submit','Cancel',modBody); 
	}
	
	
	/**
	* Defines the behaviour after the user clicks on the delete public key button within "existing public keys" form.
	* The function creates and shows to the user a confirmation modal. If the user confirms the public key deletion the 
	* request is sent to the server for deleting the key.
	* In case the deletion was successful the function re-initiates all public key related forms, because of the new user profile.
	* @param {String} description of the public key to be asked for the deletion.
    * @private
	* @memberOf PublicKeys#
	*/
	onDeleteKeyPressed = function(keyDescription){
		//id,okId,okBtnText,closeBtnText,body
		var modalBody = '<h5 class="centered">'+Messages.confirmKeyDeletionQuestion +'</h5><br/>'+
						'<p class="centered">'+"Key Description: "+ keyDescription+'</p>';
		Utils.createConfirmModal('deleteKeyConfirmation','deleteKeyConfirmedBtn','YES','NO',modalBody);
		Utils.showModal('#deleteKeyConfirmation');
		$('#deleteKeyConfirmedBtn').on('click',function(){
			deletePublicKeyOnServer(keyDescription);
		});
	};
	
	
	/**
	* Triggers sending a request to the server for the deletion of the current user.
	* If the deletion was successful the function shows an appropriate message to the user in the specially created success modal window.
	* @param {String} public key description to be asked for the deletion.
    * @private
	* @memberOf PublicKeys#
	*/
	deletePublicKeyOnServer = function(keyDescription){
		var msg = Server.deletePublicKey(keyDescription);
		isSuccessMsg = msg.find('span').hasClass('alert-success');
		clearPublicKeysErrors();
		(isSuccessMsg)? 
					Utils.showSuccessModal(msg)
						:
					$('#existingUserKeyErrors').append(msg);

		updatePublicKeyRelatedForms();
		Certificates.initPublicKeySelect();
		Utils.hideModal('#deleteKeyConfirmation');
	}
	
	
	/**
	* Creates a download button for the specified public key, defines download functionality and initializes 
	* the twitter bootstrap tooltip for it placed on the top with "Download" hint.
	* @param {String} key_description is public key description
	* @param {String} key_string is a public key value
	* @return download button object
    * @private
	* @memberOf PublicKeys#
	*/
	createPublicKeyDownloadBtn = function(keyDescription,keyString){	
		var downloadBtn = $('<a>')
							.addClass('btn btn-inverse span5 ')
							.html('<i class="icon-download icon-large nopadding"></i>').
							on('click',function(){
								var blob = new Blob([keyString], {type: "text/plain;charset=utf-8"});
								saveAs(blob, keyDescription+".txt");
							});
							
		downloadBtn.tooltip({'title': "Download",'placement':"top"});
		
		return downloadBtn;
	};
	
	
	/**
	* Clears all public keys related error container fields. All error messages are removed from the public key management form.
    * @private
	* @memberOf PublicKeys#	
	*/
	clearPublicKeysErrors = function(){
		Utils.clearErrorMessagesFrom("#newUserKeyErrors");
		Utils.clearErrorMessagesFrom("#existingUserKeyErrors");
	};
	
	
	/**
	* Handles the file selection procedure. It shows an error message to the user if any error occurs while the file selection.
	* The function checks if the selected file is a appropriate public key file (extension) and has right public key content (currently only size is checked). 
	* @param selection_event is file selection event from the select file form
    * @private
	* @memberOf PublicKeys#
	*/
	handleFileSelect = function(evt){
	    evt.stopPropagation();
		evt.preventDefault();
		var f = evt.target.files[0]; // FileList object	
		var output;			
		if (!f) {
			Utils.setErrorMessageTo("#newUserKeyErrors",Messages.failToLoadFile);
		}else {			
			var checked = checkPublicKeyFile(f);
			setTimeout(function(){
				if(checked)output = readFile(f); // correct file selected
			},100)
		}
	};
	
	/**
	* Reads file as a text from the given file object. After the file is successfully read the information about the file and its content and is shown to the user.
	* @param file object to read file as a text from.
    * @private
	* @memberOf PublicKeys#
	*/
	readFile = function(file){
		var reader = new FileReader();
		reader.readAsText(file);
		reader.onload = function(e){
			contents = e.target.result;
			setPublicKeyFromFile(contents);
		};		  
		showSelectedFileInfo(file);	
	};
	
	
	/**
	* The creates the container for showing the information about the currently selected file to the user.
	* @param {Object} file object to show information for.
    * @private
	* @memberOf PublicKeys#
	*/
	showSelectedFileInfo = function(file){
		// files is a FileList of File objects. List some properties.
		var output = [];
		output.push('<strong>', escape(file.name), '</strong> (', file.type || 'n/a', ') - ',
			file.size, ' bytes, last modified: ',
			file.lastModifiedDate ? file.lastModifiedDate.toLocaleDateString() : 'n/a');
			
		if(output.length > 0){
			var fileInfo = $('#currentFileInfo');
			fileInfo.children().remove();
			setTimeout(function(){
				fileInfo.append('<span class="alert alert-info centered span12">Currently selected: '+ output.join('')+'</span>')
			},50);
		}
	};
	
	
	/**
	* Clears the all of the related containers representing the information about the currently selected public key file.
    * @private
	* @memberOf PublicKeys#
	*/
	resetSelectedFileInfo = function(){
		$('#currentFileInfo').children().remove();
		$('#currentFileInfo').append('<span id="currentFileName" class="alert alert-info span3 centered">No file selected</span>');
		$('#publicKeyFromFile').find('textarea').val("");
		$('#currentFileName').html('No file selected.');
		$('#inputKeyDescription').val('');
	}
	
	
	/**
	* Checks the given file if it is a valid public key file. The file extension and file size are verified. 
	* @param {Object} file object to be verified.
	* @return true is returned if public key file extension and file size are a valid ones otherwise it returns false
    * @private
	* @memberOf PublicKeys#
	*/
	checkPublicKeyFile = function(f){
		Utils.clearErrorMessagesFrom('#newUserKeyErrors');
		var isValid = checkPublicKeyFileExtension(f) && checkPublicKeyFileSize(f);
		return isValid;
	};
	
	
	/**
	* Checks the given file has a valid file extension. 
	* @param {Object} file object to be verified.
	* @return true is returned if public key file extension is a valid one otherwise false is returned.
    * @private
	* @memberOf PublicKeys#
	*/
	checkPublicKeyFileExtension = function(file){	
		var fileExt = file.name.split('.').pop();
		var isValid = Validation._isValidPublicKeyFileExtension(fileExt);
		if(!isValid)Utils.addErrorMessageTo('#newUserKeyErrors',Messages.wrongPublicKeyFileExt);
		return isValid;
	};
	
	
	/**
	* Checks the given file has a valid file size. 
	* @param {Object} file object to be verified.
	* @return true is returned if public key file has an appropriate file size otherwise false is returned.
    * @private
	* @memberOf PublicKeys#
	*/
	checkPublicKeyFileSize = function(file){
		var fileSize = file.size;
		var isValid = Validation._isValidPublicKeyFileSize(fileSize);
		if(!isValid)Utils.addErrorMessageTo('#newUserKeyErrors',Messages.wrongPublicKeyFileSize);
		return isValid;
	};
	
	/**
	* Finds the textarea container for representing selected public key value and fills it with the given text.
	* The textarea container is identified by "#publicKeyFromFile textarea" selector
	* @param {String} text to be put into the container.
    * @private
	* @memberOf PublicKeys#
	*/
  	setPublicKeyFromFile = function(text){
	  var container = $("#publicKeyFromFile textarea");
	 // console.log(container);
	  container.html(text)
	};
	
	initTooltipForPublicKeyFromFile =function(){
		$('#publicKeyFromFile textarea').tooltip({trigger: 'focus', title: Messages.keyValueHint});
	}
	
	return PublicKeys;

});
