(function() {
    'use strict';
    angular
        .module('refiereApp.editArtist')
        .controller('editArtistCtrl', editArtistCtrl);

    editArtistCtrl.$inject = ['EditArtistSrv', 'currentUser', '$uibModalInstance', '$state', '$window', '$scope'];

    function editArtistCtrl(EditArtistSrv, currentUser, $uibModalInstance, $state, $window, $scope) {
        $scope.currentUser = currentUser;
        $scope.newUserUpdateData ={};
        $scope.newUserUpdateData ={
          nameUser: "",
          birthday: "",
          password: "",
          countryLocation: "",
          identificationNumber: 11,
          gender: ""
        };
        $scope.newUserUpdateData.musisicalGenres = [];
        $scope.isCalendarOpen = false;

        getGenresList();
        getUbicationsList();

        function getGenresList() {
          EditArtistSrv.getGenresList()
            .then(function(genresData){
             $scope.genres = genresData.data;
            })
        }

        function getUbicationsList() {
          EditArtistSrv.getUbicationsList()
            .then(function(ubicationData){
             $scope.ubications = ubicationData.data;
            })
        }


        $scope.ok = function() {
          console.log($scope.newUserUpdateData);
          EditArtistSrv.postUpdateArtist($scope.newUserUpdateData,$scope.picfile)
            .then(function(data) {
              if (data.status === 200){
                $window.alert("Datos actualizados con éxito");
                $uibModalInstance.close();
              }
              else if (data.status === 404){
                $window.alert('Por favor ingrese los datos correctos.');
              }
              else{
                $window.alert('Ocurrió un error con la conexión');
              }
            })
            .catch(function(error) {
              console.log(error);
              $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
            });

        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss('cancel');
        };
    }
})();
