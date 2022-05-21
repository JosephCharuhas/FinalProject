var trips = JSON.parse(data);
const h2 = document.querySelector('h2');
    const myArticle = document.createElement('article');
    const myPara1 = document.createElement('p');
    myPara1.textContent = trips[0].name; 
    myArticle.appendChild(myPara1);
    h2.appendChild(myArticle);
