function addResource(node, resource) {
    var res_node = document.createElement("div");
    res_node.setAttribute("id", resource);
    node.appendChild(res_node);
    updateStatus(resource, -1);
}

function updateStatus(resource, status) {
    node = document.getElementById(resource);
    if (status == 0) {
        var logo = 'check-square';
        var name = 'success';
    } else if (status == 1) {
        var logo = 'warning';
        var name = 'warning';
    } else if (status == 2) {
        var logo = 'times-circle-o';
        var name = 'danger';
    } else {
        var logo = 'question-circle';
        var name = 'default';
    }
    var data = {
        resource_name:resource,
        resource_status_logo:logo,
        resource_status_name:name,
    }
    node.innerHTML = tmpl("item_tmpl")(data);
}

function showTestData() {
	var results = document.getElementById("results");
	addResource(results, "UnitTest");
	updateStatus("UnitTest", 0);
}