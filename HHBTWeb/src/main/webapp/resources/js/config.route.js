angular.module('myApp').config(function ($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('home');
  $stateProvider.state('home', {
    templateUrl: 'views/home.html',
    url: '/home',
    controller: 'homeController'
  });
  // Admin List
  /* .state('admin', {
       url: '/admin',
       templateUrl: 'views/admin/admin.html',
       controller: 'adminController'
   });*/

});