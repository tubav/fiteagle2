define(['require','utils','server'], 
function(require,Utils,Server){
	
	/** 
     * Profile class.
     * The Profile class contains functions for user profile form initialisation and management
     * @class
     * @constructor
     * @return Profile object
     */
	Profile = {};
	
	/**
	* The function defines the behaviour after the request for deleting a user profile is send to the server.
	* It shows the appropriate message within a modal body and sign the current user after closing the info modal
	* by clearing the session storage and loading the login page.
	* @private
	* @memberOf Profile#
	*/
	afterDeleteFunction = function(){	
		Utils.showSuccessModal(Messages.userDeleted,'userDeletedBtn')
		$('#userDeletedBtn').on('click',function(){
			Utils.hideModal('#deleteUserProfileModal')
			require('mainPage').signOut();
		});
		modalFooter.append(okBtn);
	};
	
	/**
	* The function performs all necessary steps after the user has been updated on the server.
	* It updates the current user profile to the information received from the server and shows the 
	* appropriate message a success or an error one depending on the current state.
	* @param {String} message to be shown in the manage user profile form 
	* message container identified by "#userProfileErrors" selector.
	* @private
	* @memberOf Profile#
	*/
	afterProfileUpdate = function(msg){
		setProfileFields(Utils.getCurrentUser());
		isSuccessMsg = msg.find('span').hasClass('alert-success');
		if(isSuccessMsg){
			Utils.showSuccessModal(msg);
		}else{
			Utils.clearErrorMessagesFrom('#userProfileErrors');
			$('#userProfileErrors').append(msg);
		}
		Utils.updateUserInfoPanel();
		setTimeout(function(){
			$('#saveProfileLoadingSign').addClass('hidden'); // hide loading sign
		},50);
	};
	
	/**
	* Checks if the previous value defers from the currently entered for the given object
	* If the information is not equals the previous one then "changed" class is added.
	* @param {Object} input object to check for value changes.
	* @private
	* @memberOf Profile#
	*/
	checkIfChanged = function(object){
		var t = object;
		var currentValue = t.val();
		var defaultValue = t.attr('data-default');		
		if(currentValue != defaultValue){ 
			if(!t.hasClass('changed'))t.addClass('changed');	
		}else{
			t.removeClass('changed');
		}
	};
	
	/**
	* The function performs validation of the all input values from a managing user profile form.
	* @return {Boolean} true if all of the value are valid and false otherwise.
	* @private
	* @memberOf Profile#
	*/
	checkUserProfileEntries = function(){
		
		Utils.clearErrorMessagesFrom("#userProfileErrors");
		
		var fn  = Utils.checkInputField(
								"#inputFirstName",
								"#userProfileErrors",
								Validation._isName,
								Messages.emptyUsername,
								Messages.wrongUsername
								);
		var ln = Utils.checkInputField(
								"#inputLastName",
								"#userProfileErrors",
								Validation._isName,
								Messages.emptyLastName,
								Messages.wrongLastName);
								
		var aff =  Utils.checkInputField(
									"#inputAffiliation",
									"#userProfileErrors",
									Validation._isAffiliation,
									Messages.emptyAffiliation,
									Messages.wrongAffiliation
									);
		var email = Utils.checkInputField(
								"#inputEmail",
								"#userProfileErrors",
								Validation._isEmail,
								Messages.emptyEmailAddress,
								Messages.wrongEmailAddress);
								
		return (fn && ln && aff && email);
	};
	
	/**
	* Defines focus change on enter click for every input field from the user profile form.
	* After enter click on last input field it triggers click on the 'save' button.
	* @private
	* @memberOf Profile#
	*/
	defineOnEnterClicks = function(){
		Utils.changeFocusOnEnterClick("#inputFirstName","#inputLastName");
		Utils.changeFocusOnEnterClick("#inputLastName","#inputAffiliation");
		Utils.changeFocusOnEnterClick("#inputAffiliation","#inputEmail");
		Utils.addOnEnterClickEvent("#inputEmail","#saveProfileInfo");
	};
	
	/**
	* Defines the behaviour after changing of the user profile field value. The function checks if the given
	* information defers from the current user profile and if any changes are available is toggles "save" button 
	* availability so the user profile can changed and uploaded to the server.
	* @private
	* @memberOf Profile#
	*/
	defineOnFieldValueChange = function(){
		var inputs = $('#manageProfileContainer').find('input');
		inputs.each(function(){
			$(this).on('keyup',function(){
				checkIfChanged($(this));
				toggleSaveBtn();
			});
		});
	};
	
	/**
	* Enables the availability of the 'save' button identified by "#saveProfileInfo" selector  
	* @private
	* @memberOf Profile#
	*/
	enableSaveProfileBtn = function(){
		console.log("enabling");
		$('#saveProfileInfo').removeClass('disabled');
	};
	
	/**
	* Collect the changed information from the managing user profile form and stores it in the new object.
	* The object can be used in the request to the user for updating the user profile information.
	* @return {Object} collected user profile changes object 
	* @private
	* @memberOf Profile#
	*/	
	getUserProfileChanges = function(){
		profileChanges = new Object();		
		($('#inputUsername').hasClass('changed'))    ?   profileChanges.username = $('#inputUsername').val()   : "";
		($('#inputFirstName').hasClass('changed'))   ?   profileChanges.firstName = $('#inputFirstName').val() : "";
		($('#inputLastName').hasClass('changed'))    ?   profileChanges.lastName = $('#inputLastName').val()   : "";
		($('#inputAffiliation').hasClass('changed')) ?   profileChanges.affiliation = $('#inputAffiliation').val() : "";
		($('#inputEmail').hasClass('changed'))       ?   profileChanges.email = $('#inputEmail').val() : "";	
		return profileChanges;
	};
	
	/**
	* Initializes the 'delete' user profile button on click behaviour. The button is identified by "#deleteUserBtn" selector.
	* The function shows a confirmation modal, where user may approve his decision.
	* If the user submits the profile deletion by clicking on 'YES' button within a confirmation modal,
	* the delete user request is send to the server.
	* @private
	* @memberOf Profile#
	*/
	initDeleteUserProfileBtn = function(){
		$('#deleteUserBtn').on('click',function(){
		    var pBody = $('<div class="centered">'+Messages.confirmUserDeletionQuestion+'</div>');
			Utils.createConfirmModal('deleteUserProfileModal','deleteUserConfirmedBtn','YES','NO',pBody);
			Utils.showModal('#deleteUserProfileModal');
			$('#deleteUserConfirmedBtn').on('click',function(){
				Utils.hideModal('#deleteUserProfileModal');
				Server.deleteUser(afterDeleteFunction);	
			});
		});
	};
	
	/** 
	* Triggers the form initialization procedure for user profile managing purposes.
	* @public
	* @name Profile#initForm
	* @function
	*/
	Profile.initForm = function(){
		initProfileFields();		
		initSaveProfileInfoBtn();
		initDeleteUserProfileBtn();
	};
	
	/**
	* Initializes the user profile fields. The function gets the information about the current user and
	* fills on all of the profile form fields with the appropriate data. It also defines on enter click events for 
	* changing the focus to the next field and enables save button if any changes on a user profile are made.
	* @private
	* @memberOf Profile#
	*/
	initProfileFields = function(){
		Utils.clearErrorMessagesFrom("#manageProfile .errorMessages");
		setProfileFields(Utils.getCurrentUser());
		defineOnEnterClicks();
		defineOnFieldValueChange();
	};
	
	/**
	* Defines the behaviour after clicking on the "save" button within manage user profile form.
	* The function checks all of the changed values entered by a user for a validity and sends them to the
	* server in order to update user's profile.
	* @see Server#updateUser for sending an updating user request.
	* @private
	* @memberOf Profile#
	*/
	initSaveProfileInfoBtn = function(){
		var saveBtn = $("#saveProfileInfo");
		saveBtn.on('click',function(){		
			if(checkUserProfileEntries() && !saveBtn.hasClass('disabled')){
				$('#saveProfileLoadingSign').removeClass('hidden');
				//console.log(JSON.stringify(getUserProfileChanges()));
				var msg = Server.updateUser(getUserProfileChanges());
				afterProfileUpdate(msg);
			}
		});
	};
	
	/**
	* Checks if there is any changes to be saved for the given user profile.
	* The function looks for "changed" class availability that represents new user profile information.
	* @private
	* @memberOf Profile#
	*/
	isAnyFieldChanges =function(){
		var result = false;
		var changes = $('#manageProfileContainer').find('input').filter('.changed');
		if(changes.length != 0) result = true;
		return result;
	};
	
	/**
	* Fills up all of the input fields within the manage user profile form
	* with the information retrieved from the current user profile.
	* @private
	* @memberOf Profile#
	*/
	setProfileFields = function(user){
		$("#inputUsername")
			.val(user.username)
			.attr('data-default',user.username);
		$("#inputFirstName")
			.val(user.firstName)
			.attr('data-default',user.firstName);
		$("#inputLastName")
			.val(user.lastName)
			.attr('data-default',user.lastName);
		$("#inputAffiliation")
			.val(user.affiliation)
			.attr('data-default',user.affiliation);
		$("#inputEmail")
			.val(user.email)
			.attr('data-default',user.email);
	};
	
	/**
	* Toggles availability for a "save" button identified by the "#saveProfileInfo" selector.
	* @private
	* @memberOf Profile#
	*/
	toggleSaveBtn = function(){
		var saveBtn = $('#saveProfileInfo');
		if(isAnyFieldChanges()){
			saveBtn.removeClass('disabled');	// show btn		
		}else{
			(!saveBtn.hasClass('disabled')) ? saveBtn.addClass('disabled') : ""; // hide btn
		}
	};	
	
	return Profile;

});
