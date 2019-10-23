	var app = new Vue({
	    el: '#app',
	    data: {
	    	
	    	director: [],
	    	year: [],
	        titles: [],
	        images:[],
	        inputvalue: "",
	        titlesfiltered: [],
	        directorfiltered: [],
	        yearfiltered: [],
	        imagesfiltered: [],
	        titlesoriginal: [],
	        names:""

	    },
	    created: function () {
	        this.getData();
	       


	    },

	    methods: {

	        getData: function () {
	            fetch("http://localhost:8080/api/movies", {
	                method: "GET"

	            }).then(function (response) {
	                if (response.ok) {
	                    console.log(2);

	                    return response.json();
	                }

	            }).then(function (json) {
	            	app.data = json;	            	
	                app.movies = app.data ;
	                
	                
	                
	                app.titles=app.movies.title;
	                app.director=app.movies.director;
	                app.year=app.movies.year;
	                app.images=app.movies.url;
	                app.imagesoriginal=app.movies.url;
	                app.directororiginal=app.movies.director;
	                app.yearoriginal=app.movies.year;
	                app.titlesoriginal = app.movies.title
	                
	             



	            }).catch(function (error) {
	                console.log("Request failed:" + error.message);
	            });


	        },

	        filter: function () {
	        	
	        	 this.directorfiltered= [];
	  	        this.yearfiltered= [];
	  	        this.imagesfiltered=[];

	        	this.titlesfiltered = [];
	        	 this.titles = this.titlesoriginal
	        	
	        	
	        	 for (var r = 0; r < this.titles.length; r++){
	        		 
	        		 this.names = this.titles[r].toUpperCase();
	        		 
	        		 
	        		 if (this.names.includes(this.inputvalue.toUpperCase())) {
	                     this.titlesfiltered.push(this.titles[r])
                           
	                     
	                    
	                     this.directorfiltered.push(app.movies.director[r])
	                      this.yearfiltered.push(app.movies.year[r])
	                      this.imagesfiltered.push(app.movies.url[r])

	                     
	                 }
	        		 
	        	 }
	        	 this.titles = this.titlesfiltered;
	        	 this.director = this.directorfiltered;
	        	 this.year = this.yearfiltered;
	        	 this.images= this.imagesfiltered;
	     
	        	 
	        	
	        	
	        },
	       




	    },
	    
	   


	})
	if ( navigator.platform.indexOf('Win') != -1 ) {
		  window.document.getElementById("wrapper").setAttribute("class", "windows");
		} else if ( navigator.platform.indexOf('Mac') != -1 ) {
		  window.document.getElementById("wrapper").setAttribute("class", "mac");
		}
