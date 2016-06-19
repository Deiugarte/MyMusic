(function() {
  'use strict';

  angular
    .module('refiereApp.login')
    .controller('LoginCtrl', LoginCtrl);

  LoginCtrl.$inject = ['$state', 'LoginSrv', '$window','$log', 'UserDataService'];

  /* @ngInject */
  function LoginCtrl($state, LoginSrv, $window,$log,UserDataService) {
    var vm = this;

    vm.loginData = {};
    vm.login = login;

    function login() {

      LoginSrv.verifyUser(vm.loginData)
        .then(function(data) {

          var userInfo = data.data;
          userInfo.name = vm.loginData.login;
          UserDataService.setUserInfoData(userInfo);

          if (data.status === 200){
            if(userInfo.RoleIdentifier==12){
              $state.go('fanProfile');
            }
            if(userInfo.RoleIdentifier==11){
              $state.go('artistProfile');
            }
            if(userInfo.RoleIdentifier==10){
              $state.go('adminProfile');
            }
          }

        })
        .catch(function(error) {
          $window.alert('Por favor ingrese los datos correctos.');
        });
    }
  }

})();
