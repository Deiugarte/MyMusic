(function () {
  'use strict';
  angular
    .module('refiereApp.register')
   .directive('pwCheck', pwCheck);

function pwCheck () {
      return {
          require: 'ngModel',
          link: function (scope, elem, attrs, ctrl) {
              var firstPassword = '#' + attrs.pwCheck;
              elem.add(firstPassword).on('keyup', function () {
                  scope.$apply(function () {
                      console.info(elem.val() === $(firstPassword).val());
                      ctrl.$setValidity('pwmatch', elem.val() === $(firstPassword).val());
                  });
              });
          }
      }
  });

})();