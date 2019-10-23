let data;

fetch("http://localhost:8080/api/movies", {
	                method: "GET"

	            }).then(function (response) {
	                if (response.ok) {
	                    console.log(2);

	                    return response.json();
	                }

	            }).then(function (json) {
	            	 data = json;	            	
                    names = data.title;
                    director = data.director;
                    year = data.year
                    images = data.url;
                     getInfo ();
                     renderItems();
	                
	              
                    console.log(names)
                    console.log(director)
                    console.log(images)
                    console.log(year)	                
	             
	            }).catch(function (error) {
	                console.log("Request failed:" + error.message);
	            });


function getInfo (){

    dataBase = [

    
        {
            id: 1,
            name: names[0],
            price: 2.99 
        },
        {
            id: 2,
            name: names[1],
            price: 2.99
        },
        {
            id: 3,
            name: names[2],
            price: 2.99
        },
        {
            id: 4,
            name: names[3],
            price: 2.99
        },
        {
            id: 5,
            name: names[4],
            price: 2.99
        },
        {
            id: 6,
            name: names[5],
            price: 2.99
        },
        {
            id: 7,
            name: names[6],
            price: 2.99
        },
        {
            id: 8,
            name: names[7],
            price: 2.99
        },
        {
            id: 9,
            name: names[8],
            price: 2.99
        },
        {
            id: 10,
            name: names[9],
            price: 2.99
        }
    
    ]

console.log(names)

}



let $items = document.querySelector('#items');
let cart = [];
let total = 0;
let $cart = document.querySelector('#cart');
let $total = document.querySelector('#total');

function renderItems () {
    for (let info of dataBase) {
        let node = document.createElement('div');
        node.classList.add('card', 'col-sm-4');

        let nodeCardBody = document.createElement('div');
        nodeCardBody.classList.add('card-body');

        let nodeTitle = document.createElement('h5');
        nodeTitle.classList.add('card-title');
        nodeTitle.textContent = info['name'];

        let nodeprice = document.createElement('p');
        nodeprice.classList.add('card-text');
        nodeprice.textContent = info['price'] + '$';

        let nodeButton = document.createElement('button');

        nodeButton.classList.add('btn', 'btn-primary');
        nodeButton.textContent = '+';
        nodeButton.setAttribute('mark', info['id']);
        nodeButton.addEventListener('click', addToCart);
        nodeCardBody.appendChild(nodeTitle);
        nodeCardBody.appendChild(nodeprice);
        nodeCardBody.appendChild(nodeButton);
        node.appendChild(nodeCardBody);
        $items.appendChild(node);
    }
}
function addToCart () {

    cart.push(this.getAttribute('mark'))
    totalCalculate();
    renderCart();

}

function renderCart () {

    $cart.textContent = '';
    
    cart.forEach(function (item, index) {
        
        let miItem = dataBase.filter(function(itemDataBase) {
            return itemDataBase['id'] == item;
        });
        
        let node = document.createElement('li');
        node.classList.add('list-group-item', 'text-right');
        node.textContent = `${miItem[0]['name']} - ${miItem[0]['price']}$ `;
        
        let myButton = document.createElement('button');
        myButton.classList.add('btn', 'btn-danger');
        myButton.textContent = 'X';
        myButton.setAttribute('position', index);
        myButton.addEventListener('click', deleteItemCart);
        
        node.appendChild(myButton);
        $cart.appendChild(node);
    })
}

function deleteItemCart () { 
   
    let position = this.getAttribute('position');
   
    cart.splice(position, 1);
    
    renderCart();
    
    totalCalculate();
}

function totalCalculate () {
    
    total = 0;
    
    for (let item of cart) {
        
        let miItem = dataBase.filter(function(itemDataBase) {
            return itemDataBase['id'] == item;
        });
        total = total + miItem[0]['price'];
    }
    
    $total.textContent = total.toFixed(2);
}

