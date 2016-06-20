(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('modalAlbumCtrl', modalAlbumCtrl);

    modalAlbumCtrl.$inject = ['AlbumSrv', 'currentEvent', '$uibModalInstance', '$state', '$window', '$scope'];

    function modalAlbumCtrl(AlbumSrv, currentEvent, $uibModalInstance, $state, $window, $scope) {
        $scope.currentEvent = currentEvent;

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentEvent);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
