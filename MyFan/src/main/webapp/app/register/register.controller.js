(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .controller('RegisterCtrl', RegisterCtrl);

  RegisterCtrl.$inject = ['RegisterSrv', '$state', '$window','$scope','Upload','UserDataService'];

  /* @ngInject */
  function RegisterCtrl(RegisterSrv, $state, $window,$scope,Upload,UserDataService) {
    var vm = this;
    vm.newUserData = {};
    vm.newUserData.musicalGenres = [];
    $scope.members = [{}];
    vm.newUserData.members=$scope.members;
    vm.saveNewCompany = saveNewCompany;
    vm.registerNewUser = registerNewUser;
    vm.registerNewArtist = registerNewArtist;
    vm.plans = {};
    vm.type='fanatic';

     $scope.dateOptions = {
       showWeeks: false,
       datepickerMode:"year"
     };
     $scope.open1 = function() {
        $scope.popup1.opened = true;
      };

      $scope.popup1 = {
        opened: false
      };

      $scope.members = [{}];

   $scope.addNewChoice = function() {
     var newItemNo = $scope.members.length+1;
     $scope.members.push({});
   };

   $scope.removeChoice = function() {
     var lastItem = $scope.members.length-1;
     $scope.members.splice(lastItem);
   };

    getGenresList();
    getUbicationsList();
    function getGenresList() {
      RegisterSrv.getGenresList()
        .then(function(genresData){
          vm.genres = genresData.data;
        })
    }
    function getUbicationsList() {
      RegisterSrv.getUbicationsList()
        .then(function(ubicationData){
          vm.ubications = ubicationData.data;
        })
    }

    function registerNewUser(){
      RegisterSrv.postNewFanatic(vm.newUserData,vm.picfile)
        .then(function(data) {
          var userInfo = data.data;
          UserDataService.setUserInfoData(userInfo);
          if (data.status === 200){

            $state.go('login');
          }
          else if (data.status === 404){
            $window.alert('Por favor ingrese los datos correctos.');
          }
          else if (data.status === -1){
            $window.alert('¡El usuario ya existe!');
          }
          else{
            $window.alert('Ocurrió un error con la conexión');
          }
        })
        .catch(function(error) {
          console.log(error);
          $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
        });
    }
    function registerNewArtist(){
      RegisterSrv.postNewArtist(vm.newUserData,vm.picfile)
        .then(function(data) {
          if (data.status === 200){
            $state.go('login');
          }
          else if (data.status === 404){
            $window.alert('Por favor ingrese los datos correctos.');
          }
          else if (data.status === -1){
            $window.alert('¡El usuario ya existe!');
          }
          else{
            $window.alert('Ocurrió un error con la conexión');
          }
        })
        .catch(function(error) {
          console.log(error);
          $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
        });
    }
    function saveNewCompany() {
      RegisterSrv.postCompanyInfo(vm.newCompanyData)
        .then(function(data) {
          // console.log(data.status);
          if (data.status === 200){
            $window.alert('Bienvenido ' + vm.newCompanyData.UserRequest.login + '.' );
            $state.go('fanProfile');
          }
          else if (data.status === 400){
            $window.alert('Por favor ingrese los datos correctos.');
          }
          else if (data.status === -1){
            $window.alert('¡El usuario ya existe!');
          }
          else{
            $window.alert('Ocurrió un error con la conexión');
          }
        })
        .catch(function(error) {
          console.log(error);
          $window.alert('¡El usuario ya existe, intentelo con otro usuario!');
        });
    }
  }

})();
