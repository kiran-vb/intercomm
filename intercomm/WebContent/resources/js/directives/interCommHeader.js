intercomm
    .directive('intercommHeader', [ intercommHeader]);

function intercommHeader() {

    return {
        restrict: 'E',
        templateUrl: 'resources/html/home.html',
        scope: {},
        link: function($scope, elem, attrs) {
        	
        }
        
    };
    
}