'use strict';

(function() {
  var cnamAppApp = angular.module('cnamAppApp');

  cnamAppApp.controller('MainCtrl', ['remboursementsParAnneeResource', 'depenseParAnneeResource', '$scope', function(remboursementsParAnneeResource, depenseParAnneeResource, $scope) {
    console.log('MainCtrl');
    var setGraphData = function(resource) {
      var p = remboursementsParAnneeResource.query().$promise;
      p.then(function(data) {
        $scope.series = ['Series A'];
        $scope.graphData = [];
        $scope.labels = [];
        $scope.graphData.push([]);
        for (var i = 0; i < data.length; i++) {
          console.log(data[i].annee);
          $scope.labels.push(data[i].annee);
          $scope.graphData[0].push(data[i].montant)
        }
      })
    }

    setGraphData(remboursementsParAnneeResource);

    $scope.update = function() {
      if ($scope.graph === 'remboursement') {
        console.log("remboursement");
        setGraphData(remboursementsParAnneeResource);
      } else if ($scope.graph === 'depense') {
        console.log("depense");
        setGraphData(depenseParAnneeResource);
      }
   }
  }]);
})();
