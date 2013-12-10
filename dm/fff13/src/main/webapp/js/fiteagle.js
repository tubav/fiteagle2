function addResource(node, resource) {
    var res_node = document.createElement("div");
    res_node.setAttribute("id", resource);
    node.appendChild(res_node);
    updateStatus(resource, -1);
}

function updateStatus(resource, status, statustext) {
    node = document.getElementById(resource);
    logo = 'question-circle';
    name = 'default';
    statustext = 'unknown';
    if (status == 0) {
        logo = 'check-square';
        name = 'success';
        statustext = 'unlimited bandwidth';
    } else if (status == 1) {
        logo = 'warning';
        name = 'warning';
        statustext = 'limited bandwidth';
    } else if (status == 2) {
        logo = 'times-circle-o';
        name = 'danger';
        statustext = 'error';
    }
    var data = {
        resource_name:resource,
        resource_status:statustext,
        resource_status_logo:logo,
        resource_status_name:name,
    };
    node.innerHTML = tmpl("item_tmpl")(data);
}

function showTestData() {
	var results = document.getElementById("results");
	addResource(results, "Samsung S4");
	updateStatus("Samsung S4", 0, "unlimited");
	updateStatus("Samsung S4", 1, "reduced");
}
