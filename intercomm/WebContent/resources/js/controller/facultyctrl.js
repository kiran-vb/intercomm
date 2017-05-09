

angular.module('intercomm').controller(
    'facultyCtrl', ['$scope','$http',studentAddController
    ]);


function studentAddController($scope,$http){
	console.log(" facultyCtrl loaded !!!! ");
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
	
	$scope.createFaculty=function(){
		
		
		var formjson = JSON.stringify(getFormJson($('form').serializeArray()));
		                                               
		
		console.log(formjson);
		console.log("createFaculty function !!!! ");
		$http({
			  method: 'POST',
			  url: '/api/addFaculty',
			  data:formjson,
			}).then(function successCallback(response) {
			   console.log("addFaculty ajax Succes !!!!!");
			  }, function errorCallback(response) {
				  console.log("addFaculty ajax Fail !!!!!");
			  });
	};
}







