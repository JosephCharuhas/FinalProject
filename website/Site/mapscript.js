var indexnum = window.location.hash.substring(1);
//console.log(indexnum);
var trips = JSON.parse(data);
const gpxfilename = trips[indexnum].gpxfile;

//heading
const h2 = document.querySelector('h2');
const myArticle = document.createElement('article');
const myPara1 = document.createElement('p');
myPara1.textContent = trips[indexnum].name; 
myArticle.appendChild(myPara1);
h2.appendChild(myArticle);

//heading
const p3 = document.querySelector('p3');
const myArticle2 = document.createElement('article');
const myPara2 = document.createElement('p');
myPara2.textContent = 'Pictures:'; 
myArticle2.appendChild(myPara2);
p3.appendChild(myArticle2);



var map = L.map('map').setView([38.98, -76.49], 10);
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiZ2VjaGFydWhhcyIsImEiOiJjbDM4eDN0cHcwNDcwM2NtdXF5cWM0bzd2In0.kgHVey-0vS1Er3wr5NJN1w'
}).addTo(map);

var gpx = gpxfilename; // URL to your GPX file or the GPX itself
new L.GPX(gpx, {async: true}).on('loaded', function(e) {
  map.fitBounds(e.target.getBounds());
}).addTo(map);
