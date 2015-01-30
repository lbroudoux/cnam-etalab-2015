'use strict';

(function(){
  var cnamService = angular.module('cnamService', ['ngResource']);

  cnamService.factory('remboursementsParAnneeResource', ['$resource',
    function($resource){
      return $resource('http://localhost:9000/json/montantParAnnee.json');
    }]);


  cnamService.factory('depenseParAnneeResource', ['$resource',
    function($resource){
      return $resource('http://localhost:9000/json/depenseParAnnee.json');
    }]);

})();




