const CARD_DECK  = 'card-deck';
const MY_CARD_DECK  = 'my-card-deck';
const LIST_SMALL = 'list-small';
const LIST_LARGE = 'list-large';

function toggle_view_mode(mode) {// mode - new mode
    console.log('toggle_view_mode mode='+mode);

    content.className = mode;

    // activate mode icon
    document.getElementById(LIST_LARGE).classList.remove("active");
    document.getElementById(LIST_SMALL).classList.remove("active");
    document.getElementById(CARD_DECK).classList.remove("active");
    document.getElementById(mode).classList.add('active');

    let x = document.getElementsByClassName("action");// actions edit and delete
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.add(MY_CARD_DECK);
            x[i].classList.remove(LIST_SMALL, LIST_LARGE);
            break;
          case LIST_SMALL:
            x[i].classList.add(LIST_SMALL);
            x[i].classList.remove(MY_CARD_DECK, LIST_LARGE);
            break;
          case LIST_LARGE:
            x[i].classList.add(LIST_LARGE);
            x[i].classList.remove(LIST_SMALL, MY_CARD_DECK);
            break;
        }
    }

    x = document.getElementsByClassName("item-icon");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.add(MY_CARD_DECK, 'card-img-top');
            x[i].classList.remove(LIST_SMALL, LIST_LARGE);
            break;
          case LIST_SMALL:
            x[i].classList.add(LIST_SMALL);
            x[i].classList.remove(MY_CARD_DECK, 'card-img-top', LIST_LARGE);
            break;
          case LIST_LARGE:
            x[i].classList.add(LIST_LARGE);
            x[i].classList.remove(LIST_SMALL, MY_CARD_DECK, 'card-img-top');
            break;
        }
    }

    x = document.getElementsByClassName("item-img");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.remove('col-2');
            break;
          case LIST_SMALL:
            x[i].classList.add('col-2');// browser prevents from existing class addition
            break;
          case LIST_LARGE:
            x[i].classList.add('col-2');// browser prevents from existing class addition
            break;
        }
    }

    x = document.getElementsByClassName("item-header");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.remove('col-2');
//            x[i].classList.add('card-header');
            x[i].classList.add(/*'card-body',*/ 'card-text');
            break;
          case LIST_SMALL:
//            x[i].classList.remove('card-header');
            x[i].classList.remove(/*'card-body',*/ 'card-text');
            x[i].classList.add('col-2');// browser prevents from existing class addition
            break;
          case LIST_LARGE:
//            x[i].classList.remove('card-header');
            x[i].classList.remove(/*'card-body',*/ 'card-text');
            x[i].classList.add('col-2');// browser prevents from existing class addition
            break;
        }
    }

    x = document.getElementsByClassName("item-text");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.remove('col-6');
            x[i].classList.add(/*'card-body',*/ 'card-text', 'scroll-box');
            break;
          case LIST_SMALL:
            x[i].classList.remove(/*'card-body',*/ 'card-text', 'scroll-box');
            x[i].classList.add('col-6');// browser prevents from existing class addition
            break;
          case LIST_LARGE:
            x[i].classList.remove(/*'card-body',*/ 'card-text', 'scroll-box');
            x[i].classList.add('col-6');// browser prevents from existing class addition
            break;
        }
    }

    x = document.getElementsByClassName("item-footer");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.remove('col-1');
            x[i].classList.add('card-footer');
            break;
          case LIST_SMALL:
            x[i].classList.remove('card-footer');
            x[i].classList.add('col-1');// browser prevents from existing class addition
            break;
          case LIST_LARGE:
            x[i].classList.remove('card-footer');
            x[i].classList.add('col-1');// browser prevents from existing class addition
            break;
        }
    }

    x = document.getElementsByClassName("pricelist-item");
    for (let i = 0; i < x.length; i++) {
        switch(mode) {
          case CARD_DECK:
            x[i].classList.remove('row');
            x[i].classList.add('card', 'text-center', 'border-primary', 'mb-3');
            break;
          case LIST_SMALL:
            x[i].classList.remove('card', 'text-center', 'border-primary', 'mb-3');
            x[i].classList.add('row');// browser prevents from existing class addition
            break;
          case LIST_LARGE:
            x[i].classList.remove('card', 'text-center', 'border-primary', 'mb-3');
            x[i].classList.add('row');// browser prevents from existing class addition
            break;
        }
    }

}
