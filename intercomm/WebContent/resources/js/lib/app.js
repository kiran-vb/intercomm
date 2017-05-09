
   var mktplc = angular.module('marketplace', 
		          ['ui.router',
		           'ngRoute', 
		           'hpe.directive',
		           'hpe.service',
		           'ngDialog',
		           'angularUtils.directives.dirPagination',
		           '720kb.tooltips'
		           ]);

   mktplc.factory('PreloadService', ['$http', '$q', 'commonService', function($http, $q, commonService){
	   
	    return {
	         
            fetchConstantsList: function() {//Fetches category list from server.
                
            	var constObj = commonService.getConstantsList();
            	if(_.isEmpty(constObj)){
		   			return $http.get("api/getEntireConstantsList")
		   			.then(
		   				function(response,status,header,config){
		   					commonService.setConstantsList(response.data);
		   					return response.data;
		   				}, 
		   				function(errResponse){
                        console.error('Error while fetching constants');
                        return $q.reject(errResponse);
		   				}
		   			);
            	}else{
            		return constObj;
            	}           	
            	
            },
            fetchTranslationList : function(){
            	var urlParams = commonService.getNodeJsUrl();
            	var localeCountry = urlParams.localeCountry;
                var transObj = commonService.getTranslation();
                if (_.isEmpty(transObj) || (!_.isEmpty(transObj) && transObj.locale != localeCountry)) {
                	var translationUrl= "api/getTranslation/" + localeCountry;
		   			return $http.get(translationUrl)
		   			.then(
		   				function(response,status,header,config){
		   					return commonService.processTranslation(response[0], transObj);
		   				}
		   			);
                }else{
                	return transObj;
                }
            },
            fetchProductDetails: function(prodNum) {//Fetches category list from server.
                
            	var urlParams = commonService.getNodeJsUrl();
            	var localeCountry = urlParams.localeCountry;
            	
	   			return $http.get("api/getProductDetails/"+localeCountry+"?sku="+prodNum).then(function(response){
					return response.data;
	   			});
            	
            },
            fetchCurrencyInfo : function(){
            	var urlParams = commonService.getNodeJsUrl();
            	var localeCountry = urlParams.localeCountry;
                var currency = commonService.getCurrency(localeCountry);
                if (_.isEmpty(currency) || (!_.isEmpty(currency) && currency.locale != localeCountry)) {
                	var currUrl= "api/fetchCurrency/" + localeCountry;
/*		   			return $http.get(currUrl)
		   			.then(
		   				function(response,status,header,config){
		   					commonService.setCurrency(localeCountry, currency);
		   					return response.data;		   				 
		   				}
		   			);*/
		     		return ajaxRequest(currUrl, 'GET').success(function(response){
		     			commonService.setCurrency(localeCountry, currency);
	   					return response.data;		   				 
			   		 });
                }else{
                	return currency;
                }
            },
            fetchManageRule : function(){
	            
	            var urlParams = commonService.getNodeJsUrl();
            	var localeCountry = urlParams.localeCountry;
                var manRule = commonService.getManageRule(localeCountry);
                if (_.isEmpty(currency) || (!_.isEmpty(currency) && currency.locale != localeCountry)) {
                	var manageRuleUrl = "api/getManageRuleByLocale/"+localeCountry;
		   			return $http.get(manageRuleUrl)
		   			.then(
		   				function(manageRule,status,header,config){
		   					commonService.setManageRule(manageRule[0]);
		   					return manageRule[0];		   				 
		   				}
		   			);
                }else{
                	return manRule;
                }
            },
            ajaxRequest : function (url, method) {
            	return $http({
         	        method: method ? method : 'GET',
         	        url: url,
         	        headers: {
                        "Accept": "application/json; charset=utf-8",
            			"Cache-Control" : "no-cache",
            			"Pragma" : "no-cache",
            			"If-Modified-Since" : "0"
                    }
         	    });           	
            }
	    };
	 
	}]);