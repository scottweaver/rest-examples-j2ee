'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('MyCtrl1', [function() {

  }])
  .controller('MyCtrl2', [function() {

  }])
  .controller('QuoteListCtrl',   function ($scope, $http) {
            $http.get('/webapi/quotes').success(function(data) {
              $scope.quotes = data;
             });

  });
//  .controller('QuoteListCtrl', ['$scope',  'Quotes', function ($scope, Quotes) {
//       var data = Quotes.query
//       alert(data)
//      $scope.quotes = data;
//    }]);
