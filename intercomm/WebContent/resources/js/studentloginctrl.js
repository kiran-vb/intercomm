

angular.module('intercomm').controller(
    'studentLoginCtrl', ['$scope','$http',studentAddController
    ]);


function studentAddController($scope,$http){
	console.log("new studentLoginCtrlgot loaded !!!! ");
	loadStudents();
	function getFormJson(a){
			var o = {};
			 $.each(a, function() {
			        if (o[this.name] !== undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            o[this.name].push(this.value || '');
			        } else {
			            o[this.name] = this.value || '';
			        }
			    });
			return o;
		}
	
	$scope.createStudent=function(){
		var name= $('#name').val();
		
		console.log("name ::: "+name);
		
		
		
		var formjson = JSON.stringify(getFormJson($('form').serializeArray()));
		                                               
		
		console.log(formjson);
		//console.log("studentLoginCtrlgot create Student function !!!! ");
		$http({
			  method: 'POST',
			  url: '/api/addStudent',
			  data:formjson,
			  }).then(function successCallback(response) {
			   console.log("angular ajax Succes !!!!!");
			  }, function errorCallback(response) {
				  console.log("angular ajax Fail !!!!!");
			  });
	};
	
	function loadStudents(){
		console.log("inside load students !!!");
		$http({
			  method: 'GET',
			  url: '/api/getStudentList'
			  }).then(function successCallback(response) {
			   console.log("loadStudents 2 ajax Succes !!!!!");
			   console.log(response);
			   $scope.rowCollection=response.data;
			   $scope.columns=['name', 'fatherContact','fatherName','dob','fatherOccupation','gender','religion'];
			  }, function errorCallback(response) {
				  console.log("loadStudents ajax Fail !!!!!");
			  });
	}
}







