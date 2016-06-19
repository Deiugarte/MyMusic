(function() {
    'use strict';
    angular
        .module('refiereApp.createAlbum')
        .controller('createAlbumCtrl', createAlbumCtrl);

    createAlbumCtrl.$inject = ['CreateAlbumSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function createAlbumCtrl(CreateAlbumSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;

        $scope.songs = [{}];


// --------------AGREGAR Y QUITAR CANCIONES--------------------------
        $scope.addNewChoice = function() {
          var newItemNo = $scope.songs.length+1;
          $scope.songs.push({});
        };

        $scope.removeChoice = function() {
          var lastItem = $scope.songs.length-1;
          $scope.songs.splice(lastItem);
        };

// --------------------------------------------------------

        $scope.selected = {
            currentEvent: $scope.currentUser[0]
        };
        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentUser);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
