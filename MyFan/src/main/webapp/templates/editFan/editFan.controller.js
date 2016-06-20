(function() {
    'use strict';
    angular
        .module('refiereApp.editFan')
        .controller('editFanCtrl', editFanCtrl);

    editFanCtrl.$inject = ['EditFanSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function editFanCtrl(EditFanSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;


        getGenresList();
        getUbicationsList();

        function getGenresList() {
          EditFanSrv.getGenresList()
            .then(function(genresData){
             $scope.genres = genresData.data;
            })
        }

        function getUbicationsList() {
          EditFanSrv.getUbicationsList()
            .then(function(ubicationData){
             $scope.ubications = ubicationData.data;
            })
        }

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentUser);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
