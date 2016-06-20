(function() {
    'use strict';
    angular
        .module('refiereApp.modalEvent')
        .controller('modalAlbumCtrl', modalAlbumCtrl);

    modalAlbumCtrl.$inject = ['AlbumSrv', 'currentAlbumInfo', '$uibModalInstance', '$state', '$window', '$scope'];

    function modalAlbumCtrl(AlbumSrv, currentAlbumInfo, $uibModalInstance, $state, $window, $scope) {
        $scope.currentAlbumInfo = currentAlbumInfo;
        $scope.albumCommentRating = "";

        


        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentEvent);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
