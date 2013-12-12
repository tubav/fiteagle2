function showContent(name) {
    data = { };
    $('#content').html(tmpl(name)(data));
}

function showTestbed(name, data) {
    $('#content').html(tmpl(name)(data));
}

function showTab() {
    hash = window.location.hash;
    $('li.active').removeClass('active')
    if (hash == "#history") {
        $('.historybtn').parent().addClass('active')
        showContent("tmplHistory");
    } else if (hash == "#report") {
        $('.reportbtn').parent().addClass('active')
        showContent("tmplReport");
    } else if (hash == "#ple") {
        $('.plebtn').parent().addClass('active')
        data = {
            title: "PlanetLab Europe",
            type: "check",
            color: "success",
            message: "Running normally"
        }
        showTestbed("tmplTestbed", data);
    } else if (hash == "#fpg") {
        $('.fpgbtn').parent().addClass('active')
        data = {
            title: "FUSECO Playground",
            type: "check",
            color: "success",
            message: "Running normally"
        }
        showTestbed("tmplTestbed", data);
    } else {
        showContent("tmplDashboard");
        $('.dashboardbtn').parent().addClass('active')
    }
}

window.onhashchange = showTab;
if (window.location.hash == "") window.location.hash="#dashboard";
showTab();