intercomm.config([ '$stateProvider','$locationProvider','$urlRouterProvider',
                  function($stateProvider,$locationProvider,$urlRouterProvider){
	console.log("router loaded !!! ");
	/*console.log($urlRouterProvider);*/

										 $locationProvider.html5Mode(true);
										 $locationProvider.hashPrefix('!');
										 
										 
										$stateProvider.state('student', {
	                                         url: '/student',
	                                         templateUrl: 'resources/html/StudentLogin.html'
	                                         
                                           }).state('faculty', {
		                                         url: '/faculty',
		                                         templateUrl: 'resources/html/FacultyLogin.html'
		                                         
	                                       }).state('studentReg', {
		                                         url: '/studentReg',
		                                         templateUrl: 'resources/html/StudentReg.html'
		                                         
	                                       }).state('home', {
	                                    	   templateUrl: 'resources/html/home.html'
		                                         
	                                       }).state('facultyReg',{
	                                    	   url:'/facultyReg',
	                                    	   templateUrl: 'resources/html/FacultyReg.html'
	                                       }).state('loadStudents',{
	                                    	   url:'/loadStudents',
	                                    	   templateUrl: 'resources/html/studentlist.html'
	                                       });
										
										$urlRouterProvider.otherwise('home');
	                                     
	                                 }]);
