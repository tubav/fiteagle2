define(['validation','utils','messages','server'],
function(Validation, Utils,Messages,Server){

	/** 
     * Certificates class.
     * The Certificates class contains functions required for the certificate generation form an existing
	 * public key as well as for new key pair and their certificate generation.
     * @class
     * @constructor
     * @return Certificates object
     */
	Certificates = {}
	
	/**
	* Creates a certificate textarea container and adds it to the DOM within a container identified by the "#generatedCertificate" selector.
	* The textarea is filled with the provided certificate text. The function triggers download button generation and prepeds it to
	* the generated container so the certificate can be easily downloaded by a user.
	* @param certificate value to be placed into the generated textarea container.
    * @private
	* @memberOf Certificates#
	*/
	addCertificateTextarea = function(certificate){
		$('#generatedCertificate').children().remove();
		var textarea = $('<textarea rows=10 style="resize:none" disabled></textarea>').addClass("span10");
		textarea.val(certificate);
		$('#generatedCertificate')
			.append(textarea)
			.append('<br/>')
			.append(createDownloadCertificateBtn('certificate.crt',certificate));
	};
	
	
	/**
	* The function triggers the container creation for the generated 
	* private key and its certificate.
	* @param {String} keyAndCertificate -  
    * @private
	* @memberOf Certificates#
	*/
	addKeyAndCertificateTextarea = function(keyAndCertificate){
		var beginCertIndex =  keyAndCertificate.indexOf("-----BEGIN CERTIFICATE-----");
		var privateKey = keyAndCertificate.substr(0,beginCertIndex);
		var certificate = keyAndCertificate.substr(beginCertIndex+1);
		$('#generatedKeyAndCertificate').children().remove();	
		var privateKeyContainer = 
			createTextAreaContainer('privateKeyAndCertificateContainer',
								'New generated Private Key and Cerificate',
								keyAndCertificate,
								privateKey,
								certificate
								);	
		$('#generatedKeyAndCertificate')
			.append(privateKeyContainer);
	};
	
	/**
	* Creates a button for downloading of the generated certificate.
	* @param {String} filename - name of the downloading file.
	* @param {String} certificate - certificate value, to be stored in the downloading file.
	* @return {Object} download certificate button object with the appropriate on click event listener.
	* @private
	* @memberOf Certificates#
	*/
	createDownloadCertificateBtn = function(filename,certificate){
		var downloadBtn = $('<a>')
				.addClass('btn btn-inverse span3 offset3')
				.html('<i class="icon-file-text-alt"></i>Download Certificate')
				.on('click',function(){
					var blob = new Blob([certificate], {type: "text/plain;charset=utf-8"});
					saveAs(blob, filename);
				});
		
		return downloadBtn;
	};
	
	/**
	* Creates a button for downloading of the generated private key.
	* @param {String} filename - name of the downloading file with a private key.
	* @param {String} privateKey - private key value, to be stored in the downloading file.
	* @return {Object} download private key button object with the appropriate on click event listener.
	* @private
	* @memberOf Certificates#
	*/
	createDownloadPrivateKeyBtn = function(filename,privateKey){
		var downloadBtn = $('<a>')
				.addClass('btn btn-inverse span3')
				.html('<i class="icon-file"></i>Download Private Key')
				.on('click',function(){
					var blob = new Blob([privateKey], {type: "text/plain;charset=utf-8"});
					saveAs(blob, filename);
				});
		
		return downloadBtn;
	};
	
	/**
	* Creates an select option item for a given public key description
	* @param  {String} public key description to create an select option item for
	* @return {Object} select option object with the value of the given public key description.
	* @private
	* @memberOf Certificates#
	*/
	createOptionItem = function(keyDescription){	
		//console.log("Creating option");
		var opt  = $('<option>').html(keyDescription);
		return opt;
	};
	
	/**
	* Creates textarea container for representing a generated certificate and private key
	* with specified container identifier, header text, content and private key and certificate values
    * for creation of the appropriate download buttons. 	
    * @private
	* @memberOf Certificates#
	* @return {Object} generated certificate and private key container including the appropriate download buttons. 
	*/
	createTextAreaContainer = function(containerID, headerText, content, privateKey, certificate){
		var container = $('<div>').attr('id',containerID).addClass('row-fluid');
		var textarea = $(
			'<textarea id="generatedPrivateKey" rows=10 style="resize:none" disabled></textarea>'
			).addClass("span10").val(content);
		var header = $('<h5 class="top20"></h5>').text(headerText);
		container
			.append(header)
			.append('<hr/>')
			.append(
				$('<div class="row-fluid certificateControls"></div>')
					.append(createDownloadPrivateKeyBtn('privateKey.ppk',privateKey))
					.append(createDownloadCertificateBtn('certificate.crt', certificate))
			)
			.append(textarea).append('<br/>');
			
		return container;
	};
	
	/**
	* Requests from a server a list of the all public keys stored in a profile of the current user
	* @return {Array} user public keys array 
	* @private
	* @memberOf Certificates#
	*/
	getUserPublicKeysFromServer = function(){
		var username = Utils.getCurrentUser().username;
		var user = Server.getUser(username);	
		return user.publicKeys;
	};
	
	
	/**
	* Triggers functions for the certificate management form initialization. It initializes public key select element that contains all the public keys 
	* from the current user profile. It defines the behaviour for the certificate generation from the existing public key as well as generation of the certificate and 
    * the corresponding certificate.	
	* @public
	* @name Certificates#initForm
	* @function
	**/
	Certificates.initForm = function(){
		Certificates.initPublicKeySelect();	
		initGenerateCertificatesBtn();
		initPassphraseField();
		initGenerateKeyAndCertificateBtn();
		$(window).bind('resizeEnd',function(){
			initPassphraseField();
		});
	};
	
	/**
	* Initializes the behaviour after clicking on the button for the generation of the certificate from the currently selected public key.
    * @private
	* @memberOf Certificates#
	*/
	initGenerateCertificatesBtn = function(){
		$("#genPubKey").on('click',function(){
			var loadingSign = $('#genPubKeySign');
			loadingSign.removeClass('hidden'); //show loading sign
			var selectedKeyDescription = $("#publicKeySetSelect option:selected").html();
			//console.log("KEY DESCRIPTION: " + selectedKeyDescription);
			var pubStringCertificate = Server.generateCertificateForPiblicKey(selectedKeyDescription);
			if(pubStringCertificate){
					addCertificateTextarea(pubStringCertificate);
			}
			setTimeout(function(){
				loadingSign.addClass('hidden'); // hide loading sign
			},50);
		}).tooltip({title: Messages.generateCertificateFromKey});
	};
	
	/**
	* Initializes the button for the ssh key pair generation and the appropriate certificate for it.
	* The function defines the button hint in a tooltip.
	* It defines on the button click behaviour. It checks if the pass-phrase for the private key is valid,
	* Sends the request to the server, evaluates it and shows the responded message to the user, updates all of
	* the related public key forms.
	* @see Server#generatePublicKeyAndCertificate for generate public keys and certificate request towards the server
    * @private
	* @memberOf Certificates#
	*/
	initGenerateKeyAndCertificateBtn = function(){
		$('#genKeyAndCertificate').on('click',function(){
			var loadingSign = $('#genKeyAndCertificateSign');
			loadingSign.removeClass('hidden'); //show loading sign
			Utils.clearErrorMessagesFrom('#newKeypairAndCertificateErrors');
			var passphrase = $('#inputPassphrase').val();
			var isPassphraseValid = Utils.checkInputField(
										"#inputPassphrase",
										"#newKeypairAndCertificateErrors",
										Validation._isPassphrase,
										Messages.emptyPassphrase,
										Messages.wrongPassphrase
									);
			if(isPassphraseValid){		
				var repsonse = Server.
							generatePublicKeyAndCertificate(
								passphrase);
				
				var keyAndCertificate = repsonse[0];
				//console.log(keyAndCertificate);
				var errorMessage = repsonse[1];				
				console.log(errorMessage);
				if(!errorMessage){			
					addKeyAndCertificateTextarea(keyAndCertificate);
					require('publicKeys').updateExistingPublicKeyForm();
					Certificates.initPublicKeySelect();
				}else{
					Utils.addErrorMessageTo('#newKeypairAndCertificateErrors');
				}
			}
			setTimeout(function(){
				loadingSign.addClass('hidden'); // hide loading sign
			},50);
		}).tooltip({title: Messages.generateKeyPairAndCertificate});
	};
	
	/**
	* Initiates twitter botstrap tooltip depending on the current screen size. 
	* Tooltip on top for small screens and on the right side for a large ones.
	* @private
	* @memberOf Certificates#
	*/
	initPassphraseField = function(){		
		Utils.addOnEnterClickEvent("#inputPassphrase","#genKeyAndCertificate");
		var placement;
		(Utils.isSmallScreen())? placement ="top" : placement = "right";
		Utils.initTooltipFor("#inputPassphrase",Messages.passphraseHint,placement,"focus");
	};
	
	
	/**
	* Triggers select element initiation for existing user public keys representation.
	* It fills the selector object identified by "#selectKeyForGeneration" selector with the
	* options of the user public keys if there are keys available, otherwise it shows an info message,
	* that no public keys are available.
	* @public
	* @name Certificates#initPublicKeySelect
	* @function
	*/
	Certificates.initPublicKeySelect = function(){
		var selectPubKey = $('#selectKeyForGeneration');
		selectPubKey.children().remove();
		var publicKeys = getUserPublicKeysFromServer();
		var label;
		if(publicKeys.length == 0){ // if no keys	
			Utils.hideElement("#pubicKeySetLabel");
			selectPubKey.append('<span class="alert alert-info span8">'+Messages.noPublicKeys+"</span>");
			$("#genPubKey").addClass('disabled');
			
		}else{ // if keys exists	
			$("#genPubKey").removeClass('disabled');
			label = $('<label>')
				.addClass('span2')
				.html("Please select a public key");
			var sel = $('<select>')
				.addClass('span12')
				.attr("id","publicKeySetSelect");
			
			var selDiv = $('<div>').addClass('span8').append(sel);	
			
			for(var i = 0; i < publicKeys.length; i ++){
				var description = publicKeys[i].description;
				sel.append(createOptionItem(description));
			}
			selectPubKey.append(label);
			selectPubKey.append(selDiv);
		}			
	};
		
	return Certificates;
});
