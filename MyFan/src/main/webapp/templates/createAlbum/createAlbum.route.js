(function() {
  'use strict';

  angular
    .module('refiereApp.createAlbum')
    .config(setupRoutes);

  function setupRoutes($stateProvider) {
    $stateProvider
      .state('createAlbum', {
        url: '/createAlbum',
        templateUrl: '/templates/createAlbum/view.html',
        controller: 'createAlbumCtrl as vm'
      });
  }
})();
