(function() {
  'use strict';

  angular
    .module('refiereApp.register')
    .controller('RegisterCtrl', RegisterCtrl);

  RegisterCtrl.$inject = ['RegisterSrv', '$state', '$window','$scope','Upload'];

  /* @ngInject */
  function RegisterCtrl(RegisterSrv, $state, $window,$scope,Upload) {
    var vm = this;
    vm.newUserData = {};
    vm.newUserData.musicalGenres = [];
    vm.saveNewCompany = saveNewCompany;
    vm.registerNewUser = registerNewUser;
    vm.plans = {};


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

      $scope.choices = [{id: 'choice1'}, {id: 'choice2'}];

   $scope.addNewChoice = function() {
     var newItemNo = $scope.choices.length+1;
     $scope.choices.push({'id':'choice'+newItemNo});
   };

   $scope.removeChoice = function() {
     var lastItem = $scope.choices.length-1;
     $scope.choices.splice(lastItem);
   };




    getPlans();
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
    function getPlans() {
      RegisterSrv.getPlansFromServer()
        .then(function(plansData){
          vm.plans = plansData.data;
        })
    }
    function registerNewUser(){
      RegisterSrv.postNewFanatic(vm.newUserData,vm.picfile)
        .then(function(data) {
          // console.log(data.status);
          if (data.status === 200){
            $window.alert('Bienvenido' );
            $state.go('app.dashboard');
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
            $state.go('app.dashboard');
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
