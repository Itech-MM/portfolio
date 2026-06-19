$(document).ready(function() {
    $('#contactForm').on('submit', function(e) {
        e.preventDefault();

        const $form = $(this);
        const $formBody = $form.find('.form-body');
        const $submitBtn = $('#contactSubmitBtn');
        const $btnContent = $submitBtn.find('.btn-content');
        const $successCard = $('#formSuccessCard');
        const $errorMsg = $('#contactErrorMessage');

        $submitBtn.prop('disabled', true);
        $btnContent.html('<i class="fas fa-spinner fa-spin"></i> Sending...');
        $errorMsg.fadeOut();

        $.ajax({
            url: $form.attr('action'),
            type: $form.attr('method'),
            data: $form.serialize(),
            success: function(response) {
                $formBody.fadeOut(350, function() {
                    $form[0].reset();

                    $successCard.fadeIn(200, function() {
                        $successCard.addClass('animate-success');
                    });
                });
            },
            error: function(xhr, status, error) {
                $errorMsg.text('Could not deliver message. Please check your connection and try again.').fadeIn();

                $submitBtn.prop('disabled', false);
                $btnContent.html('<i class="fas fa-arrow-right"></i> Send message');

                console.error("AJAX Error Details: ", error);
            }
        });
    });
});