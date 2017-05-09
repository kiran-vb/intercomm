angular
    .module('intercomm')
    .directive('intercommFooter,$http', [ intercommFooter]);

function intercommFooter($http) {

    return {
        restrict: 'E',
        templateUrl: 'resources/html/Footer.html',
        scope: {},
        link: function($scope, elem, attrs) {
        	
        }
        
    };
    
}