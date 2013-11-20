var results = document.getElementById("results");

function getRootUri() {
	return "ws://"
			+ (document.location.hostname == "" ? "localhost"
					: document.location.hostname) + ":"
			+ (document.location.port == "" ? "8080" : document.location.port);
}

function onError(evt) {
	alert(evt.data);
}

function onOpen(evt) {
	websocket.send("push");
}

function onMessage(evt) {
	data = JSON.parse(evt.data);
	resource = data.resource;
	status = data.status;
	if (null == document.getElementById(resource)) {
		addResource(results, resource);
	}

	updateStatus(resource, status);
}

function showError(message) {
	addResource(results, message);
}

try {
	var success = false;
	websocket = new WebSocket(getRootUri() + "/ws/fff13");
	websocket.onopen = function(evt) {
		success = true;
		onOpen(evt);
	};
	websocket.onmessage = function(evt) {
		onMessage(evt);
	};
	websocket.onerror = function(evt) {
		onError(evt);
	};
	websocket.onclose = function() {
		if (!success)
			showError("connection error");
	}
} catch (e) {
	showError(e.message);
}