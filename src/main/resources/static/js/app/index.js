var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-reply-save').on('click',function (){
            _this.replySave();
        });

        $('#btn-reply-update').on('click',function (){
            _this.replyUpdate();
        });

        $('#btn-reply-delete').on('click',function (){
            _this.replyDelete();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    replySave : function () {

            var id = $('#postsId').val();

            var data = {
            postsId: $('#postsId').val(),
            comment: $('#comment').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/posts/'+ id +'/reply',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('댓글이 등록되었습니다.');
                window.location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

        replyUpdate : function () {
                var data = {
                    comment: $('#comment').val()
                };

                var commentId = $('#commentId').val();

                $.ajax({
                    type: 'PUT',
                    url: '/api/v1/reply/' + commentId,
                    dataType: 'json',
                    contentType:'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert('댓글이 수정되었습니다.');
                    window.location.href = '/';
                }).fail(function (error) {
                    alert(JSON.stringify(error));
                });
            },

    replyDelete : function (postsId,commentId) {

            const con_check = confirm("삭제하시겠습니까?");

            var id = $('#postsId').val();
            var commentId = $('#commentId').val();

         if (con_check===true){
            $.ajax({
                type: 'DELETE',
                url: '/api/v1/posts/'+ id +'/reply/' + commentId,
                contentType:'application/json; charset=utf-8',
            }).done(function() {
                alert('댓글이 삭제되었습니다.');
                window.location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
            }
        },


};

main.init();