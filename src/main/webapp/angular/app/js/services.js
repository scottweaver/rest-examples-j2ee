'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.

var myAppServices = angular.module('myApp.services', ['ngResource']);

myAppServices.value('version', '0.1');

myAppServices.factory('Quotes', ['$resource',
  function($resource){
    return $resource('/webapi/quotes', {},  {
      query: {method:'GET', params:{}, isArray:true}
    });
  }]);

