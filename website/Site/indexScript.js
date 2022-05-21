var trips = JSON.parse(data);
const h3 = document.querySelector('h3');
//console.log(someData_notJSON);
var countindex = 0;

for (const trip of trips) {
    const myArticle = document.createElement('article');

    var temp_link = document.createElement("a");
    temp_link.href = "trip.html#" + countindex;
    temp_link.target = '_blank';
    temp_link.innerHTML = " (view trip)";

    const myPara1 = document.createElement('p');
    myPara1.textContent = trip.name;

    myPara1.innerHTML = trip.name;
    myPara1.appendChild(temp_link);         
    myArticle.appendChild(myPara1);
    h3.appendChild(myArticle);
    countindex++;
}