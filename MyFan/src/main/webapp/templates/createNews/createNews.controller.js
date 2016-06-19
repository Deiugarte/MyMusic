(function() {
    'use strict';
    angular
        .module('refiereApp.createNews')
        .controller('createNewsCtrl', createNewsCtrl);

    createNewsCtrl.$inject = ['CreateNewsSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function createNewsCtrl(CreateNewsSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
        $scope.isCalendarOpen = false;
        $scope.selected = {
            currentUser: $scope.currentUser[0]
        };

        $scope.ok = function() {
            $uibModalInstance.close($scope.selected.currentUser);
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
