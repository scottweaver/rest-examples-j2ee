'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
  controller('MyCtrl1', [function() {

  }])
  .controller('MyCtrl2', [function() {

  }])
  .controller('QuoteListCtrl', function ($scope) {
      $scope.quotes = [
        {'quoteId': '10000',
         'revision': '1'},
        {'quoteId': '20000',
         'revision': '2'},
        {'quoteId': '30000',
         'revision': '3'}
      ];
    });
