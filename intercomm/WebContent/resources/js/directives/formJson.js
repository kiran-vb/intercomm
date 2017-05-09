angular
    .module('intercomm')
    .directive('formJson', [ intercommFooter]);

function intercommFooter() {

    return {
        restrict: 'A',
        scope: {},
        link: function($scope, elem, attrs) {
        	console.log("id is :::: "+attrs.id);
        }
        
    };
    
}