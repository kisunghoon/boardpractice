(function(){

    // 바다
    var $waterFront = $('#water-front');
    var $waterBack = $('#water-back');

    (function loopSea(){
        $waterFront
            .animate({'bottom': '-65px', 'left': '-30px'}, 500)
            .animate({'bottom': '-60px', 'left': '-25px'}, 500);

        $waterBack
            .animate({'bottom': '15px', 'left': '-20px'}, 500)
            .animate({'bottom': '10px', 'left': '-25px'}, 500);

        $.when($waterFront, $waterBack).done(loopSea);
    })();

    // 구름
    var $cloud1 = $('#cloud-group-1');
    var $cloud2 = $('#cloud-group-2');

    (function loopCloud(){
        $cloud1
            .animate({'left': '-720px'}, 10000, "linear")
            .animate({'left': '0px'}, 0);
        	// easing 값 : "swing", "linear"
			// https://api.jquery.com/animate/#easing
        $cloud2
            .animate({'left': '0px'}, 10000, "linear")
            .animate({'left': '720px'}, 0, loopCloud);
    })();


    // 보트 & 타이틀 & 폼
    var $boat = $('#boat');
    var $questionMark = $('#question-mark');
	var $title1 = $('#title1');
	var $title2 = $('#title2');
	var $form = $('#form');

    $boat.css({'left': '-220px'});  // 시작위치 화면 바깥
    $questionMark.css({'opacity': 0});  // 최초에 투명
	$title1.css({ 'opacity' : 0 }); // 타이틀 첨에는 안보이기
	$title2.css({ 'opacity' : 0 });
	$form.css({ 'left' : '370px' }); // 폼은 우측 바깥

    // 방법1 : animate() +  callback 사용
    // $boat.animate({'left': '20px'}, 2000, function(){
    //     loopBoat();  // 보트 두둥실
    //     $questionMark.delay(500).animate({'opacity': 1}, 1000, function(){
    //         $title1.animate({'opacity': 1}, 1000, function(){
    //             $title2.animate({'opacity': 1}, 1000, function(){
    //                 $form.animate({'left': 0}, 500); // end $form
    //             }); // end $title2
    //         }); // end $title1
    //     }); // end $questionMark
    // }); // end $boat
    // ↑ callback hell 발생...

	// 방법2 : .when() .then() 사용
	// when() 은 Promise 객체를 리턴
	// Thenable object 란 : 'then' 메소드를 갖고 있는 object

    // $.when($boat.animate({'left': '20px'}, 2000))
    //     .then(function(){
    //         loopBoat();
    //         return $.when($questionMark.delay(500).animate({'opacity': 1}, 1000));
    //     })
    //     .then(function(){
    //         return $.when($title1.animate({'opacity': 1}, 1000));
    //     })
    //     .then(function(){
    //         return $.when($title2.animate({'opacity': 1}, 1000));
    //     })
    //     .then(function(){
    //         $form.animate({'left': 0}, 500);
    //     })

    // 방법3 : 단일 애니메이션의 연속인 경우 promise() 만으로도 가능.
    $boat.animate({'left': '20px'}, 2000).promise()
        .then(function(){
            loopBoat();
            return $questionMark.delay(500).animate({'opacity': 1}, 1000).promise();
        })
        .then(function(){
            return $title1.animate({'opacity': 1}, 1000).promise();
        })
        .then(function(){
            return $title2.animate({'opacity': 1}, 1000).promise();
        })
        .then(function(){
            $form.animate({'left': 0}, 500);
        })

    // 보트 두둥실
    function loopBoat(){
        $boat
            .animate({'bottom': '15px'}, 500)
            .animate({'bottom' : '25px'}, 500, loopBoat)
    }


})();