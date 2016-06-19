(function() {
    'use strict';
    angular
        .module('refiereApp.editArtist')
        .controller('editArtistCtrl', editArtistCtrl);

    editArtistCtrl.$inject = ['EditArtistSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function editArtistCtrl(EditArtistSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
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
