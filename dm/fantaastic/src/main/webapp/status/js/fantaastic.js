// to be changed to real data
function getData() {
	fan = {
		title : "fanTaaStic Federator",
		type : "check",
		color : "success",
		long : "Running normally",
		short : "UP",
		id : "fan",
		message : "No issue reported or monitored",
		services : [ {
			name : "Billing System",
			type : "check",
			color : "success",
		}, {
			name : "Resource Catalog",
			type : "check",
			color : "success",
		}, {
			name : "Experimenter Interface",
			type : "check",
			color : "success",
		}, ]
	};
	ple = {
		title : "PlanetLab Europe",
		type : "check",
		color : "success",
		long : "Running normally",
		short : "UP",
		id : "ple",
		message : "No issue reported or monitored",
		services : [ {
			name : "PlanetLab Central",
			type : "check",
			color : "success",
		}, {
			name : "Virtual machines",
			type : "check",
			color : "success",
		} ]
	};
	fpg = {
		title : "FUSECO Playground",
		type : "check",
		color : "success",
		long : "Running normally",
		short : "UP",
		id : "fpg",
		message : "No issue reported or monitored",
		services : [ {
			name : "FITeagle",
			type : "check",
			color : "success",
		}, {
			name : "Virtual machines",
			type : "check",
			color : "success",
		}, {
			name : "WiFi connectivity",
			type : "check",
			color : "success",
		}, {
			name : "LTE connectivity",
			type : "check",
			color : "success",
		}, {
			name : "2G connectivity",
			type : "check",
			color : "success",
		}, {
			name : "3G connectivity",
			type : "check",
			color : "success",
		}, {
			name : "OpenEPC as a Service",
			type : "check",
			color : "success",
		}, {
			name : "OpenEPC client (Laptop)",
			type : "check",
			color : "success",
		}, {
			name : "OpenEPC client (Samsung S4)",
			type : "check",
			color : "success",
		}, {
			name : "OpenEPC client (Samsung S4)",
			type : "check",
			color : "success",
		}, {
			name : "Seamless Handover as a Service through MME",
			type : "check",
			color : "success",
		}, {
			name : "Attenuator",
			type : "check",
			color : "success",
		}, {
			name : "QoS based controllable Core Network",
			type : "check",
			color : "success",
		}, {
			name : "OpenSDNCore",
			type : "check",
			color : "success",
		}, {
			name : "OpenIMSCore",
			type : "check",
			color : "success",
		}, ]
	};

	data = {
		'fan' : fan,
		'fpg' : fpg,
		'ple' : ple,
	};
	return data;
}

function showContent(name) {
	data = {};
	$('#content').html(tmpl(name)(data));
}

function showTestbed(name, data) {
	show_service = tmpl("tmplTestbedServices"), html = "";
	jQuery.each(data['services'], function(i, val) {
		html += show_service(val);
	});
	data['services'] = html;
	$('#content').html(tmpl(name)(data));
}

function showTestbedCard(name, data) {
	$('#testbedCards').append(tmpl(name)(data));
}

function showTab() {
	var data = getData();
	var hash = window.location.hash;
	$('li.active').removeClass('active')

	for ( var prop in data) {
		if (hash.match("^#" + prop)) {
			$('.' + prop + 'btn').parent().addClass('active')
			showTestbed("tmplTestbed", data[prop]);
			return;
		}
	}

	if (hash.match("^#history")) {
		$('.historybtn').parent().addClass('active')
		showContent("tmplHistory");
	} else if (hash.match("^#report")) {
		$('.reportbtn').parent().addClass('active')
		showContent("tmplReport");
	} else {
		showContent("tmplDashboard");
		for ( var prop in data) {
			showTestbedCard("tmplTestbedBoard", data[prop]);
		}
		$('.dashboardbtn').parent().addClass('active')
	}
}

$(document).ready(function() {
	window.onhashchange = showTab;
	if (window.location.hash == "")
		window.location.hash = "#dashboard";
	showTab();
});
