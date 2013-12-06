define([],function(){
	
	/** 
     * Messages class contains messages for the shown to the end user. 
     * @class
     * @constructor
     * @return Messages object
     */
	Messages = {};
	
/*________ REGISTRATION FORM HINT MESSAGES _______*/
	
	/**
	* Hint message for entering a valid username.
	* @public
	* @name Messages#usernameHint
	*/
	Messages.usernameHint = "The Username may only consist of letters, numbers,  \"@\", \".\", \"_\", and \"-\" and it has to be from 3 to 200 characters long";
	
	/**
	* Hint message for entering a valid user's first name.
	* @public
	* @name Messages#firstNameHint
	*/
	Messages.firstNameHint = "Names can be from 2 to 200 characters";
	
	/**
	* Hint message for entering a valid user's last name.
	* @public
	* @name Messages#lastNameHint
	*/
	Messages.lastNameHint = "Names can be from 2 to 200 characters";
	
	/**
	* Hint message for entering a valid user's email.
	* @public
	* @name Messages#emailHint
	* @example "Please enter a valid email address."
	*/
	Messages.emailHint = "Please enter a valid email address";
	
	/**
	* Hint message for entering a valid user's affiliation.
	* @public
	* @name Messages#affiliationHint
	* @example "The affiliation should be between 2 and 20 digits, underscore, hyphen, apostrophe and dots are allowed. First letter can be only a character."
	*/
	Messages.affiliationHint = "Affiliations can be from 2 to 200 characters";
	
	/**
	* Hint message for entering a valid user's password.
	* @public
	* @name Messages#passwordHint
	* @example "Password must be between 4 and 8 digits long and include at least one numeric digit."
	*/
	Messages.passwordHint = "Passwords can be from 3 to 200 characters";
	
	/**
	* Hint message for entering a valid user's password confirmation.
	* @public
	* @name Messages#confirmPasswordHint
	* @example "Please enter password confirmation. The password has to be exactly the same you've entered in the field above."
	*/
	Messages.confirmPasswordHint = "Please enter password confirmation. The password has to be exactly the same you've entered in the field above.";
	
	/**
	* Hint message for entering a valid user's public key value.
	* @public
	* @name Messages#keyValueHint
	* @example "The public key length should be between 100 and 500 digits."
	*/
	Messages.keyValueHint = "The public key length should be between 100 and 500 digits.";
	
/*_________ LOGIN AND REGISTRATION FORM WARNING MESSAGES _________ */
	
	/**
	* Warning message after submitting an empty username value.
	* @public
	* @name Messages#emptyUsername
	* @example "Username is empty."
	*/
	Messages.emptyUsername = "Username is empty.";
	
	/**
	* Warning message after submitting an empty user's first name value.
	* @public
	* @name Messages#emptyFirstName
	* @example "User's first name is empty."
	*/
	Messages.emptyFirstName = "User's first name is empty.";
	
	/**
	* Warning message after submitting an empty user's last name value.
	* @public
	* @name Messages#emptyLastName
	* @example "User's last name is empty."
	*/
	Messages.emptyLastName = "User's last name is empty.";

	/**
	* Warning message after submitting an empty user's email value.
	* @public
	* @name Messages#emptyEmailAddress
	* @example "Email address is empty."
	*/	
	Messages.emptyEmailAddress = "Email address is empty.";
	
	/**
	* Warning message after submitting an empty user's affiliation value.
	* @public
	* @name Messages#emptyAffiliation
	* @example "Affiliation is empty."
	*/	
	Messages.emptyAffiliation = "Affiliation is empty.";
	
	/**
	* Warning message after submitting an empty user's password value.
	* @public
	* @name Messages#emptyPassword
	* @example "Password is empty."
	*/	
	Messages.emptyPassword = "Password is empty.";

	/**
	* Warning message after submitting an empty user's password confirmation value.
	* @public
	* @name Messages#emptyConfirmPassword
	* @example "Confirm password is empty."
	*/		
	Messages.emptyConfirmPassword = "Confirm password is empty." ;
	


	/**
	* Warning message after submitting a username value with a wrong syntax.
	* @public
	* @name Messages#wrongUsername
	* @example "Wrong username syntax."
	*/	
	Messages.wrongUsername = "Wrong username syntax.";
	
	/**
	* Warning message after submitting a user's first name value with a wrong syntax.
	* @public
	* @name Messages#wrongFirstName
	* @example "Wrong first name syntax."
	*/
	Messages.wrongFirstName = "Wrong first name syntax.";
	
	/**
	* Warning message after submitting a user's last name value with a wrong syntax.
	* @public
	* @name Messages#wrongFirstName
	* @example "Wrong last name syntax."
	*/
	Messages.wrongLastName = "Wrong last name syntax.";
	
	/**
	* Warning message after submitting a user's email address value with a wrong syntax.
	* @public
	* @name Messages#wrongEmailAddress
	* @example "Wrong email address."
	*/
	Messages.wrongEmailAddress = "Wrong email address.";
	
	/**
	* Warning message after submitting a user's affiliation value with a wrong syntax.
	* @public
	* @name Messages#wrongAffiliation
	* @example "Wrong Affiliation syntax."
	*/
	Messages.wrongAffiliation = "Wrong Affiliation syntax.";
	
	/**
	* Warning message after submitting a user's password value with a wrong syntax.
	* @public
	* @name Messages#wrongPassword
	* @example "The given password syntax is invalid."
	*/
	Messages.wrongPassword = "The given password syntax is invalid";
	
	/**
	* Warning message after submitting a user's password confirmation value with a wrong syntax.
	* @public
	* @name Messages#wrongConfirmPassword
	* @example "Confirm password has a wrong syntax."
	*/
	Messages.wrongConfirmPassword = "Confirm password has a wrong syntax."; 
	
	/**
	* Warning message after submitting a password and the password confirmation that aren't consistent.
	* @public
	* @name Messages#passwordsAreInconsistent
	* @example "Passwords are inconsistent."
	*/
	Messages.passwordsAreInconsistent = "Passwords are inconsistent.";
	
	/**
	* Warning message informing that the user with given username has not been found on the server.
	* @public
	* @name Messages#userNotFound
	* @example "Current user isn't found."
	*/
	Messages.userNotFound = "Current user isn't found.";
	
	/**
	* Warning message after submitting a password with a wrong key value.
	* @public
	* @name Messages#wrongPasswordKey
	* @example "Wrong password."
	*/
	Messages.wrongPasswordKey = "Wrong password.";
		
	
	
/*_____________ MAIN PAGE FORM MESSAGES _____________________________ */

	/**
	* Hint message for uploading new public key button.
	* @public
	* @name Messages#uploadNewPublicKey
	* @example "Click to upload the new public key."
	*/
	Messages.uploadNewPublicKey = "Click to upload the new public key.";

	/**
	* Hint message that no public keys are available for the given user profile. 
	* @public
	* @name Messages#noPublicKeys
	* @example "No public keys are available"
	*/
	Messages.noPublicKeys = "No public keys are available";

	/**
	* Warning message after submitting an empty public key description. 
	* @public
	* @name Messages#emptyKeyDescription
	* @example "Public key description is empty."
	*/
	Messages.emptyKeyDescription = "Public key description is empty.";

	/**
	* Hint message for submitting a public key description value. 
	* @public
	* @name Messages#keyDescription
	* @example "The public key description should be from 3 to 15 digits long. The first letter has to be a character. Only alphanumeric characters are allowed."
	*/
	Messages.keyDescription = "The public key description should be from 3 to 15 digits long. The first letter has to be a character. Only alphanumeric characters are allowed.";
	
	/**
	* Hint message for submitting a public key description value. 
	* @public
	* @name Messages#newKeyDescription
	* @example "The public key description should be from 3 to 15 digits long. The first letter has to be a character. Only alphanumeric characters are allowed."
	*/
	Messages.newKeyDescription = "The new public key description should be from 3 to 15 digits long. The first letter has to be a character. Only alphanumeric characters are allowed.";
	
	/**
	* Warning message for submitting a public key with the empty value. 
	* @public
	* @name Messages#emptyKeyValue
	* @example "Public key value is empty"
	*/
	Messages.emptyKeyValue = "Public key value is empty";

	/**
	* Warning message for submitting a public key with the wrong syntax. 
	* @public
	* @name Messages#wrongKeyValue
	* @example "The given key value syntax is wrong."
	*/	
	Messages.wrongKeyValue = "The given key value syntax is wrong.";

	/**
	* Hint message for informing the end user, to click on this field in order to change a public key description value 
	* @public
	* @name Messages#clickToChangeKeyDescription
	* @example "Click to change the public key description."
	*/		
	Messages.clickToChangeKeyDescription = "Click to change the public key description.";

	/**
	* Hint message for informing the end user, to click on this field in order to change a public key description value 
	* @public
	* @name Messages#wrongKeyDescription
	* @example "The given key description is wrong."
	*/		
	Messages.wrongKeyDescription = "The given key description is wrong.";

	/**
	* Hint message for informing the end user that the file selection is not supported on his/her system.
	* @public
	* @name Messages#fileSelectionNotSupported
	* @example "Upload New User Keys is disabled because file selection is not supported on your system."
	*/			
	Messages.fileSelectionNotSupported = "Upload New User Keys is disabled because file selection is not supported on your system.";

	/**
	* Warning message for informing the end user that an error occurs while loading a file from a system.
	* @public
	* @name Messages#failToLoadFile
	* @example "Failed to load file"
	*/		
	Messages.failToLoadFile = "Failed to load file";
	
	/**
	* Hint message for informing the end user about the starting of a process of the new ssh key and certificate creation.
	* @public
	* @name Messages#generateKeyPairAndCertificate
	* @example "Generate new key pair and a certificate for it"
	*/	
	Messages.generateKeyPairAndCertificate = "Generate new key pair and a certificate for it";

	/**
	* Hint message for informing the end user about the starting of a process
	* of the certificate generation from an existing public key.
	* @public
	* @name Messages#generateCertificateFromKey
	* @example "Generate certificate from the selected public key"
	*/		
	Messages.generateCertificateFromKey = "Generate certificate from the selected public key";

	/**
	* Warning message that the given pass-phrase for a private key has an empty value.
	* @public
	* @name Messages#emptyPassphrase
	* @example "The pass-phrase is empty."
	*/	
	Messages.emptyPassphrase = "The pass-phrase is empty.";

	/**
	* Warning message that the given pass-phrase for a private key has a wrong syntax.
	* @public
	* @name Messages#wrongPassphrase
	* @example "The given pass-phrase syntax is invalid."
	*/		
	Messages.wrongPassphrase = "The given pass-phrase syntax is invalid.";

	/**
	* Hint message that informs the end user about the right private key pass-phrase syntax.
	* @public
	* @name Messages#passphraseHint
	* @example "Password must be at least 4 characters, no more than 8 characters, and must include at least one lower case letter, and one numeric digit."
	*/		
	Messages.passphraseHint = "Password must be at least 4 characters, no more than 8 characters, and must include at least one lower case letter, and one numeric digit.";

	/**
	* Hint message that informs the end user about the right private key pass-phrase syntax.
	* @public
	* @name Messages#generateNewKeyAndCertificate
	* @example "Please wait until new key pair and certificate are being generated."
	*/	
	Messages.generateNewKeyAndCertificate = "Please wait until new key pair and certificate are being generated.";

	/**
	* Warning message that informs the end user about the wrong public key file extension.
	* @public
	* @name Messages#wrongPublicKeyFileExt
	* @example "Wrong public key file extension. The valid public key extension is 'pub'."
	*/		
	Messages.wrongPublicKeyFileExt = "Wrong public key file extension. The valid public key extension is 'pub'.";

	/**
	* Warning message that informs the end user about the wrong public key file size.
	* @public
	* @name Messages#wrongPublicKeyFileSize
	* @example "Wrong file size. Please select another public key file."
	*/		
	Messages.wrongPublicKeyFileSize = "Wrong file size. Please select another public key file";

	/**
	* Confirmation question that asks the end user to delete a public key.
	* @public
	* @name Messages#confirmKeyDeletionQuestion
	* @example "Are you sure you want to delete this public key ?"
	*/	
	Messages.confirmKeyDeletionQuestion = "Are you sure you want to delete this public key ?"; 

	/**
	* Confirmation question that asks the end user to delete the current user profile.
	* @public
	* @name Messages#confirmUserDeletionQuestion
	* @example "Are you sure you want to delete your user profile?"
	*/		
	Messages.confirmUserDeletionQuestion = "Are you sure you want to delete your user profile?";
	
	/**
	* Information message about the successful user profile deletion.
	* @public
	* @name Messages#userDeleted
	* @example "Current user profile has been successfully deleted"
	*/
	Messages.userDeleted = "Current user profile has been successfully deleted";

	/**
	* Confirmation question that asks the end user about signing out.
	* @public
	* @name Messages#signOutConfirm
	* @example "Are you sure you want to sign out ?"
	*/
	Messages.signOutConfirm = "Are you sure you want to sign out ?";
	
	return Messages;

});
