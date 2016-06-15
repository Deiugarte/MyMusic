(function(){
  'use strict';
  angular
  .module('refiereApp.fanProfile')
  .controller('fanProfileCtrl', fanProfileCtrl);

  fanProfileCtrl.$inject = ['RegisterSrv', '$state', '$window', '$scope'];

  function fanProfileCtrl($RegisterSrv, $state, $window, $scope){
    var vm = this;
    vm.newUser= {
      name:'Dei',
      age: 20,
      sex: 'Masculino',
      genres: [ 'Rock',
        'Reggae',
        'Pop'
      ],
      country: 'Costa Rica'
    };

    vm.timeline = {
    publications: [
      {
        type: "noticia",
        title: "Universal Music comercializarálos Beatles en España",
        body: "Universal Music Spain, coincidmatos DVD y Blu-ray, ha llegado a un acuerdo con Apple Corp",
        date: "20/04/2015"
      },
      {
        type: "noticia",
        title: "Se murió michael jackson",
        body: "GG legítimo",
        date: "12/03/2009"
      },
      {
        type: "evento",
        title: "Ky-Mani Marley engalanará el Reggae Festival",
        body: "Un dia de estos tocas Ki MA ni marly",
        date: "25/12/2011",
        stars: 3,
        commentsAmount: 100
      },
      {
        type: "evento",
        title: "Ky-Mani Marley engalanará el Reggae Festival",
        body: "Un dia de estos tocas Ki MA ni marly",
        date: "25/12/2011",
        stars: 5,
        commentsAmount: 20
      }
    ]
  };

  vm.timeline = {
  artists: [
    {
      name: "Red Hot Chili Peppers",
      photo: "",
      country: "Estados Unidos",
      albumsAmount: 20;
      stars: 5,
      genres:[
        "Rock",
        "Pop",
        "Funk",
        "Alternativo"
      ],
      nextEvent : "El 20 de agosto se presentan en octubre",      
    },
  ]
  };


    $scope.filtersInvisible = true;
                    $scope.showFilters = function () {
                        if ($scope.filtersInvisible) {
                            $scope.filtersInvisible = false;
                        } else {
                            $scope.filtersInvisible = true;
                        }
                    };
  }
})();
