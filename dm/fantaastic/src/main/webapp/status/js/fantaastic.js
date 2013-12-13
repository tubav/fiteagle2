// to be changed to real data
function getData() {
	ple = {
            title: "PlanetLab Europe",
            type: "check",
            color: "success",
            long: "Running normally",
            short: "UP",
            id: "ple",
            message: "No issue reported or monitored"
	};
	fpg = {
            title: "FUSECO Playground",
            type: "check",
            color: "success",
            long: "Running normally",
            short: "UP",
            id: "fpg",
            message: "No issue reported or monitored"
	};
	data = {'ple': ple,
			'fpg': fpg};
	return data;
}


function showContent(name) {
    data = { };
    $('#content').html(tmpl(name)(data));
}


function showTestbed(name, data) {
    $('#content').html(tmpl(name)(data));
}


function showTestbedCard(name, data) {
    $('#testbedCards').append(tmpl(name)(data));
}

function showTab() {
	var data = getData();
	var hash = window.location.hash;
    $('li.active').removeClass('active')

    for (var prop in data) {
    	if (hash == "#"+prop) {
    	    $('.'+prop+'btn').parent().addClass('active')
    	    showTestbed("tmplTestbed", data[prop]);
    	    return;
    	}
    }

    if (hash == "#history") {
        $('.historybtn').parent().addClass('active')
        showContent("tmplHistory");
    } else if (hash == "#report") {
        $('.reportbtn').parent().addClass('active')
        showContent("tmplReport");
    } else {
        showContent("tmplDashboard");
        for (var prop in data) {
        	showTestbedCard("tmplTestbedBoard", data[prop]);
        }
        $('.dashboardbtn').parent().addClass('active')
    }
}

    
$(document).ready(function() {
	window.onhashchange = showTab;
	if (window.location.hash == "") window.location.hash="#dashboard";
	showTab();
});
