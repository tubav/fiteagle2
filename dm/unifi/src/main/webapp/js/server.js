define(['require','utils'],
/**
 * @lends MainPage
 */ 
function(require,Utils){
	
	/** 
     * Server class contains functions that enables the remote communication with the FITeagle server REST API,  
	 * by utilizing AJAX such as user profile, public key and certificate management. 
     * @class
     * @constructor
     * @return Server object
     */
	Server = {};
	
	/**
	* The function sends a request to the server API for logging in a user with a given username and password.   
	* @param {String} username of the user to try logging in
	* @param {String} password for the given username to log in
	* @param {Boolean} rememberMe - a flag for remembering the user after the user is successful logged in.
	* true is for remembering the current user and false for not.
	* @return {String} message in case of the error the server response message is returned.
	* in case 404 status code the Messages.userNotFound message is returned.
	* in case 401 status code the Messages.wrongPasswordKey message is returned.
	* @see Messages#userNotFound
	* @see Messages#wrongPasswordKey
	* @public
	* @name Server#loginUser
	* @function
	*/
	Server.loginUser = function(username,password,rememberMe){		
		var msg;
		var signInBtn = $('#login');
		setCookie = "";
		if(rememberMe){
			setCookie="setCookie=true";
			Utils.thisUserToBeRemembered();
		}
		$.ajax({
			cache: false,
			type: "GET",
			async: false,
			data: setCookie,
			url : "/api/v1/user/"+username,
			beforeSend: function(xhr){
				signInBtn.hide();
				Utils.unhideElement('#loginForm .progress');
				xhr.setRequestHeader("Authorization",
                "Basic " + btoa(username + ":" + password)); // TODO Base64 support
			},
			success: function(user,status,xhr){		
				Utils.setCurrentUser(user);
				require('mainPage').load();
			},
			error: function(xhr,status,thrown){		
				msg = thrown;
				//console.log("Response " + xhr.responseText);
				//console.log(status);
				//console.log(thrown);
			},
			complete: function(){
				setTimeout(function(){
					signInBtn.show();
					Utils.hideElement('#loginForm .progress');
				},100);
			},
			statusCode:{				
				404: function(){
					msg = Messages.userNotFound;	
				},
				401 : function(){
					msg = Messages.wrongPasswordKey;
				}
			}
		});
		
		return msg;
	};
	
	/**
	* The function sends a request to the server API for registering a new user. If the given user is successfully 
	* registered the function then automatically sends the logging in request and loads the FITeagle main page.
	* @param {Object} newUser object contains
	* @param {String} newUsername is username for a new user to be registered with
	* @param {Function} successFunction is a callback function to be called after the new user is 
	* successfully registered.
	* @return {Object} error object containing the error response message from the server.
	* The error object is the Twitter Bootstrap alert span object
	* @see Utils#createErrorMessage and Twitter Bootstrap alert component
	* @public
	* @name Server#registerUser
	* @function
	*/
	Server.registerUser = function(newUser,newUsername,successFunction){	
		console.log("Registering a new user on a server...");
		var userToJSON = JSON.stringify(newUser);
		var message;
		//console.log("New USER "+ userToJSON);			
		$.ajax({
			cache: false,
			type: "PUT",
			async: false,
			url: "/api/v1/user/"+newUsername,
			data: userToJSON,
			contentType: "application/json",
			dataType: "json",
			success: function(data,status){	},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
				console.log(status);
			},
			statusCode:{				
				200: function(){
					console.log("New user is successfully registered");		
				},			
				201: function(){
					console.log("New user: "+ newUser.firstName +" "+newUser.lastName+ " has been successfully created.");				
					newUser.username = newUsername;
					Utils.setCurrentUser(newUser);
					Server.loginUser(newUser.username, newUser.password,false,successFunction);
				}
			}
		});
		
		return message;
	};
	
	/**
	* Sends the request to the server API for getting user profile object for the specified username.
	* In case there was an unauthorized request attempt (meaning the user is not logged on the server side) the function and currently shown page is a FITeagle main page,
	* the function triggers the sing out procedure, it is done for security reasons and other use cases.
	* If the response is a successful one the function sets the received user as a current FITeagle clien user. 
	* In case the error code is responded the information about the event is written to the browser's console.
	* @param {String} username to get the user profile object for.
	* @return {Object} user profile object containing the entire information about the user.
	* @see Main#signOut for sign out procedure.
	* @see Utils#setCurrentUser for setting a user as a current FITeagle client user.
	* @public
	* @name Server#getUser
	* @function
	*/
	Server.getUser = function(username){	
		var userFromServer = null;	
		$.ajax({
			cache: false,
			type: "GET",
			async: false,
			url : "/api/v1/user/"+username,
			beforeSend: function(xhr){
			},
			success: function(user,status,xhr){
				userFromServer = user;
				Utils.setCurrentUser(userFromServer);
			},
			error: function(xhr,status,thrown){
				console.log("Response " + xhr.responseText);
				console.log(status);
				console.log(thrown);
			},
			statusCode:{			
				401: function(){
					console.log("Unathorized access. To be signed out")
					require('mainPage').signOut();
				}
			},	
		});
		return userFromServer;
	};
	
	/**
	* Sends an AJAX request to the server API for updating the current user profile with the specified information.
	* @param {Object} upadateProfileInformation object that carries the user profile information to be updated on the server.
	* The object has to have a predefined structure so after being stringified to JSON object it can be proceed by a server.
	* @return {Object} message object. The message object is either alert-error or alert-success twitter bootstrap alert span 
	* accordingly on the server response.
	* @see Profile#getUserProfileChanges for updateProfileInformation object creation
	* @see FITeagle REST API for more information.
	* @public
	* @name Server#updateUser
	* @function
	*/
	Server.updateUser = function(updateInformation){
		//console.log("credentials" + Utils.getCredentials());
		console.log("Updating user on the server...");
		var data = JSON.stringify(updateInformation);
		var user = Utils.getCurrentUser(); 
		console.log(user);
		var message;
		$.ajax({
			cache: false,
			type: "POST",
			async: false,
			url: "/api/v1/user/"+user.username,
			data: data,
			contentType: "application/json",
			dataType: "json",
			beforeSend: function(xhr){
			},
			success: function(data,status){
				console.log("UPDATING DATA " + data);
				console.log(status);
			},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
				console.log(status);
			},
			statusCode:{			
				200: function(){
					var msg = "User has been successfully updated on the server";
					Utils.setCurrentUser(Server.getUser(user.username));
					message = Utils.createSuccessMessage(msg);
					$('#saveProfileInfo').addClass('disabled');
				}
			}
		});
		return message;
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for uploading a new public key into the current user profile. 
	* @param {Object} publicKey object. The object has to have predefined structure so it can be evaluated by a server after the function
	* stringifies it to a JSON object.
	* @see PublicKeys#createNewPublicKeyObject for public key object creation.
	* @see FITeagle REST API for more information.
	* @return {String} message object. The message object is either alert-error or alert-success twitter bootstrap alert span 
	* accordingly on the server response.
	* @public
	* @name Server#uploadNewPublicKey
	* @function
	*/
	Server.uploadNewPublicKey = function(publicKey, uploadingSign){
		
		var user = Utils.getCurrentUser();
		var username = user.username;
		var message;
		$.ajax({
			cache: false,
			type: "POST",
			async: false,
			url: "/api/v1/user/"+username+'/pubkey',
			data: JSON.stringify(publicKey),
			contentType: "application/json",
			dataType: "json",
			beforeSend: function(xhr){
				Utils.unhideElement(uploadingSign);
			},
			success: function(data,status){
				console.log(data);
				console.log(status);
			},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
			},
			statusCode:{			
				200: function(){
					var updatedUser = Server.getUser(username);
					Utils.setCurrentUser(updatedUser);
					message = Utils.createSuccessMessage("New public key with description: "
																+publicKey.description+
															" has been successfully uploaded");
				}
			},
			complete: function(){
				Utils.hideElement(uploadingSign);
			}
		});	
		
		return message;
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for generating a new certificate for a specified public key, that is already exists in a user profile.
	* In case of the error response the function writes the information about the error source to the browser's console. 
	* @param {String} publicKeyDescription is a name of the public key to generate a certificate for.
	* @return {String} generated certificate for the specified public key is returned. 
	* @public
	* @name Server#generateCertificateForPiblicKey
	* @function
	*/
	Server.generateCertificateForPiblicKey = function(publicKeyDescription){

		var username = Utils.getCurrentUser().username;
		var certificat;
		$.ajax({
			cache: false,
			type: "GET",
			async: false,
			url : "/api/v1/user/"+username+"/pubkey/"+publicKeyDescription+"/certificate",
			beforeSend: function(xhr){
				//Utils.showProgressbarModal(Messages.generateCertificate);
			},
			success: function(cert,status,xhr){
				certificat = cert;
				//console.log(xhr.responseText);
			},
			error: function(xhr,status,thrown){
				console.log("Response " + xhr.responseText);
				console.log(status);
				console.log(thrown);
			},
			complete: function(){
				//Utils.hideProgressbarModal(Messages.generateCertificate);
			}
		});

		return certificat;
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for new ssh key pair and a certificate generation.
	* @param  {String} passphrase is a password to be set as a password for the new generated private key
	* @return {Array} privateKey and certificate index 0 and errorMessage index 1 is returned.
	* If the server response message has no error in it then the returned errorMessage is null.
	* @public
	* @name Server#generatePublicKeyAndCertificate 
	* @function
	*/
	Server.generatePublicKeyAndCertificate = function(passphrase){
		var username = Utils.getCurrentUser().username;
		var keyAndCertificate;
		var errorMessage;
		$.ajax({
			cache: false,
			type: "POST",
			async: false,
			url: "/api/v1/user/"+username+'/certificate',
			data: passphrase,
			contentType: "text/plain",
			beforeSend: function(xhr){},
			success: function(data,status){
				keyAndCertificate = data;
			},
			error: function(xhl,status){
				errorMessage = xhl.responseText;
				console.log(xhl.responseText);
				console.log(status);
			},
			complete: function(){}
		});
		
		return [keyAndCertificate,errorMessage];
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for session invalidation on the server side. It is required for signing out a user,
	* that is remembered before by sending the corresponding request to the API.
	* @param {String} username is the name of the user to invalidate the session for.
	* @return {Boolean} true if the session invalidation was successful on the server side, false otherwise
	* @see Server#loginUser for remember me option
	* @see FITeagle REST API
	* @public
	* @name Server#invalidateCookie
	* @function
	*/
	Server.invalidateCookie = function(username){
		if(!username)username = Utils.getCurrentUser().username;
		isSuccessful = false;
		$.ajax({
			cache: false,
			type: "DELETE",
			async: false,
			url : "/api/v1/user/"+username+"/cookie",
			beforeSend: function(xhr){

			},
			success: function(answer,status,xhr){
				isSuccessful = true;
			},
			error: function(xhr,status,thrown){
				console.log("Response " + xhr.responseText);
				console.log(status);
				console.log(thrown);
			},
			complete: function(){
			},
		});
		
		return isSuccessful;
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for deleting a specified public key from a user profile.
    * @param {String} keyDescription is a public key description to delete from the current user profile
	* @return {Object} message object. The message object is either alert-error or alert-success twitter bootstrap alert span 
	* accordingly on the server response.
	* @public
	* @name Server#deletePublicKey
	* @function
	*/
	Server.deletePublicKey = function(keyDescription){
		var user = Utils.getCurrentUser();
		var username = user.username;
		var message;
		$.ajax({
			cache: false,
			type: "DELETE",
			async: false,
			url: "/api/v1/user/"+username+'/pubkey/'+keyDescription,
			beforeSend: function(xhr){
				//xhr.setRequestHeader("Authorization",
                //"Basic " + Utils.getCredentials()); // TODO Base64 support
			},
			success: function(data,status){
				console.log(data);
				console.log(status);
			},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
				console.log(status);
			},
			statusCode:{			
				200: function(){
					var updatedUser = Server.getUser(username);
					Utils.setCurrentUser(updatedUser);
					message = Utils.createSuccessMessage("Public key " + keyDescription+" has been successfully removed.");
				}
			},
			complete: function(){
				Utils.hideElement(uploadingSign);
			}
		});
		
		return message;
	};
	
	
	/**
	* Sends an AJAX request to the FITeagle REST API for renaming of the specified public key to the given new public key description.
	* @param {String} oldKeyDescription is a name of the public key from a user profile to be renamed.
	* @param {String} newKeyDescription is a new public key for description name renaming of the old one.
	* @return {Object} message object. The message object is either alert-error or alert-success twitter bootstrap alert span 
	* accordingly on the server response. 
	* @public 
	* @name Server#renamePublicKey
	* @function
	*/
	Server.renamePublicKey = function(oldKeyDescription, newKeyDescription){
		var user = Utils.getCurrentUser();
		var username = user.username;
		var message;
		$.ajax({
			cache: false,
			type: "POST",
			async: false,
			url: "/api/v1/user/"+username+'/pubkey/'+oldKeyDescription+'/description',
			data: newKeyDescription,
			contentType: "text/plain",
			beforeSend: function(xhr){
				//xhr.setRequestHeader("Authorization",
                //"Basic " + Utils.getCredentials()); // TODO Base64 support
			},
			success: function(data,status){
				console.log(data);
				console.log(status);
			},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
				console.log(status);
			},
			statusCode:{			
				200: function(){
					var updatedUser = Server.getUser(username);
					Utils.setCurrentUser(updatedUser);
					message = Utils.createSuccessMessage("Public key " + oldKeyDescription+" has been successfully renamed to: " + newKeyDescription+'.');
				}
			},
			complete: function(){
				//Utils.hideElement(uploadingSign);
			}
		});
		
		return message;
	};
	
	/**
	* Sends an AJAX request to the FITeagle REST API for deleting a user profile of the user logged on the server.
	* @param {Function} afterDeleteFunction - is a function to be called after the user profile has been successfully deleted.
	* @return {Object} message object. The message object is either alert-error or alert-success twitter bootstrap alert span 
	* accordingly on the server response. 
	* @public
	* @name Server#deleteUser
	* @function
	*/	
	Server.deleteUser = function(afterDeleteFunction){
		var user = Utils.getCurrentUser();
		var username = user.username;
		var message;
		$.ajax({
			cache: false,
			type: "DELETE",
			async: false,
			url: "/api/v1/user/"+username,
			beforeSend: function(xhr){
				
			},
			success: function(data,status){
				console.log(data);
				console.log(status);
				message = Utils.createSuccessMessage('Current User has been successfully deleted');
			},
			error: function(xhl,status){
				message = Utils.createErrorMessage(xhl.responseText);
				console.log(status);
			},
			statusCode:{			
				200: function(){		
					afterDeleteFunction();
				}
			},
			complete: function(){}
		});
		
		return message;
	};
		
	return Server;

});
