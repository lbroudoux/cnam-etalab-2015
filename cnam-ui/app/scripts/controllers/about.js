'use strict';

/**
 * @ngdoc function
 * @name cnamAppApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the cnamAppApp
 */
angular.module('cnamAppApp')
  .controller('AboutCtrl', function ($scope, $http) {
   //http://localhost:9000/json/montantparannee.json
	  //http://localhost:8080/depense/montantParAnnee
	  var prestations = $http.get('http://localhost:9000/json/montantParAnnee.json').success(function(data) {
		  //$scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
		  //$scope.series = ['Series A', 'Series B'];
		  
		  $scope.series = ['Series A'];
		  console.log(data.length);
		  console.log(data[0]);
		  console.log(data[0].ageBeneficiaire);
		  
		  $scope.remboursementMontantParAnnee = [];
		  $scope.labels = [];
		  $scope.remboursementMontantParAnnee.push([]);
		  for (var i = 0; i < data.length; i++) {
			  console.log(data[i].annee);
			  console.log(data[i].montant);
			  $scope.labels.push(data[i].annee);
			  $scope.remboursementMontantParAnnee[0].push(data[i].montant)
		  }
		  console.log($scope.labels);
		  console.log($scope.remboursementMontantParAnnee);
		 /*  	
		  $scope.data = [
		    [65, 59, 80, 81, 56, 55, 40],
		    [28, 48, 40, 19, 86, 27, 90]
		  ];*/  
	  });
	  
	  /*
	  $http.get('http://localhost:9000/json/depenseParAnnee.json').success(function(data) {
		  $scope.series = ['Series A'];
		  
		  $scope.depenseMontantParAnnee = [];
		  $scope.labels = [];
		  $scope.depenseMontantParAnnee.push([]);
		  for (var i = 0; i < data.length; i++) {
			  $scope.labels.push(data[i].annee);
			  $scope.depenseMontantParAnnee[0].push(data[i].montant)
		  }		  
	  });
	  
	  $http.get('http://localhost:9000/json/prestations.json').success(function(data) {
		  $scope.series = ['Series A'];
		  
		  $scope.ratio = [];
		  $scope.labels = [];
		  $scope.ratio.push([]);
		  for (var i = 0; i < data.length; i++) {
			  $scope.labels.push(data[i].annee);
			  $scope.ratio[0].push(data[i].montant)
		  }		  
	  });
	  */
	  
  });
