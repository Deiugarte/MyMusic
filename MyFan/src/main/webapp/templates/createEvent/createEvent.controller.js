(function() {
    'use strict';
    angular
        .module('refiereApp.createEvent')
        .controller('createEventCtrl', createEventCtrl);

    createEventCtrl.$inject = ['CreateEventSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope','$cookies','$cookieStore'];

    function createEventCtrl(CreateEventSrv, currentUser, $uibModalInstance, $state, $window, $scope,$cookies,$cookieStore) {
        var vm = this;
        $scope.newEventData = {};
        $scope.ubications = [];
        $scope.newEventData.idUser = $cookies.getObject('userInfo').idUser;
        $scope.isCalendarOpen = false;

        $scope.ok = function() { //método que se llama cuando se le da OK en el modal de crear evento
          console.log($scope.newEventData);
            CreateEventSrv.postCreateNewEvent($scope.newEventData)
                .then(function(data) {
                    $uibModalInstance.close();
                })
                .catch(function(error) {
                    $window.alert("No se pudo crear el evento, intente de nuevo.");
                });
        };

        $scope.cancel = function() { //método que se llama cuando se le da cancelar en el modal de crear evento
            $uibModalInstance.dismiss('cancel');
        };


        getUbicationsList();

        function getUbicationsList() {
            CreateEventSrv.getUbicationsList()
                .then(function(ubicationData) {
                    $scope.ubications = ubicationData.data;
                    console.log($scope.ubications);
                })
        }
    }
})();
