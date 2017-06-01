// Weather api key : 31448cd3d20637809d3a55949c0a6f98

function initPage() {
    loadMyLocation();
    loadCountries();
}

function loadMyLocation() {
    $.getJSON("http://ip-api.com/json/?callback=?", function (data) {
        console.log(data);
        document.getElementById("landcode").innerHTML = data.countryCode;
        document.getElementById("land").innerHTML = data.country;
        document.getElementById("regio").innerHTML = data.regionName;
        document.getElementById("stad").innerHTML = data.city;
        document.getElementById("postcode").innerHTML = data.zip;
        document.getElementById("latitude").innerHTML = data.lat;
        document.getElementById("longitude").innerHTML = data.lon;
        document.getElementById("IP").innerHTML = data.query;

        showWeather(data.lat, data.lon, data.city);
        $("#stad").click(function () {
            showWeather(data.lat, data.lon, data.city);
        });
    });
}

/*
LES5 VARIANT
function showWeather(lat, lon, city) {
    document.getElementById("weerheader").innerHTML = "Het weer in " + city;
    $.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=metric&appid=31448cd3d20637809d3a55949c0a6f98", function (data) {
        console.log(data);
        $("#temp").html(data.main.temp + "°C");
        $("#lv").html(data.main.humidity + "%");
        $("#ws").html(data.wind.speed * 3.6 + " km/u");
        $("#wr").html(windrichting(data.wind.deg));
        $("#zop").html(secondsToTime(data.sys.sunrise));
        $("#zon").html(secondsToTime(data.sys.sunset));
    });
}
*/


//LES6.PRACTICUM2 VARIANT
function showWeather(lat, long, city) {
    $("#weerheader").text("Het weer in " + city);

    if (localStorage.getItem(city) === null) {
        get();
    }
    else {
        var data = JSON.parse(localStorage.getItem(city));
        Date.now() - data.requesttime > 600000 ? get() : show(data);
    }

    function get() {
        var getURL = "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + long + "&units=metric&APPID=31448cd3d20637809d3a55949c0a6f98";

        $.get(getURL, function (weather) {
            var data = {
                temp: weather.main.temp + "°C",
                lv: weather.main.humidity + "%",
                ws: (weather.wind.speed * 3.6).toFixed(2) + " km/u",
                wr: windrichting(weather.wind.deg),
                zop: secondsToTime(weather.sys.sunrise),
                zon: secondsToTime(weather.sys.sunset),
                requesttime: Date.now()
            };

            localStorage.setItem(city, JSON.stringify(data));
            show(city);
        });
    }

    function show(data) {
        $("#temp").html(data.temp);
        $("#lv").html(data.lv);
        $("#ws").html(data.ws);
        $("#wr").html(data.wr);
        $("#zop").html(data.zop);
        $("#zon").html(data.zon);
    }
}

function loadCountries() {
    $.getJSON("http://localhost:8888/restservices/countries/GETall", function (data) {
        var countryTable = $("#myCountryList");
        $.each(data, function (index, object) {
            console.log(object);
            var String = "<tr id='row" + index + "'>" +
                "<td>" + object.name + "</td>" +
                "<td>" + object.capital + "</td>" +
                "<td>" + object.region + "</td>" +
                "<td>" + object.surface + "</td>" +
                "<td>" + object.population + "</td>" +
                "</tr>";
            countryTable.append(String);
            $("#row" + index).click(function () {
                showWeather(object.lat, object.lon, object.capital);
            });
        });
    });
}

function secondsToTime(secondsinput) {
    var date = new Date(0);
    date.setUTCSeconds(secondsinput);

    return date.toLocaleTimeString();
}

function windrichting(degrees) {
    if (degrees !== undefined) {
        var val = (degrees / 22.5);

        if (val < 0) {
            val = 0;
        } else if (val >= 15.5) {
            val = 15.4
        }

        var arr = ["N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"];
        return arr[Math.round(val)];
    }
    return null
}
