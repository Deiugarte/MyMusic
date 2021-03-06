(function() {
    'use strict';
    angular
        .module('refiereApp.createNews')
        .controller('createNewsCtrl', createNewsCtrl);

    createNewsCtrl.$inject = ['CreateNewsSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope','$cookies','$cookieStore'];

    function createNewsCtrl(CreateNewsSrv, currentUser, $uibModalInstance, $state, $window, $scope,$cookies,$cookieStore) {
      $scope.newNewsData = {};
      $scope.newNewsData.idUser =$cookies.get("idArtist");
      $scope.isCalendarOpen = false;

        $scope.ok = function() { //método que se llama cuando se le da OK en el modal de crear noticia
          console.log($scope.newNewsData);
            CreateNewsSrv.postCreateNewNews($scope.newNewsData)
                .then(function(data) {
                    $uibModalInstance.close();
                })
                .catch(function(error) {
                    $window.alert("No se pudo crear la noticia, intente de nuevo.");
                });
        };

        $scope.cancel = function() { //método que se llama cuando se le da cancelar en el modal de crear noticia
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
