
<template>
  <div>
    <div>
      <strong>{{ tweetProp.auteur.nom }} - {{tweetProp.auteur.prenom}} : </strong>
      <span class="handle">{{tweetProp.auteur.handle}} - {{momentf(tweetProp.date).fromNow()}}</span>
    </div>
    <div>
      {{tweetProp.contenu}}
    </div>
    <div>
      <ul>
        <li class="button">
          <icon name="reply"/>
        </li>
        <a v-if="canRetweet()" @click="retweet()">
        <li class="button">
            <icon name="retweet"/>{{tweetProp.retweeters.length}}
        </li>
        </a>
        <li class="button">
          <icon name="heart"/>
        </li>
        <li class="button">
          <icon name="envelope"/>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'
import moment from 'moment'
import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)

export default {
  name: 'TweetComp',
  props: ['tweetProp', 'connectedUser'],
  components: { Icon },
  methods: {
      momentf: function (date) {
        return moment(date)
      },
      retweet: function () {
                this.$http.get('http://localhost:8080/retweet', {
                  responseType: 'text',
                  params:
                    {utilisateur: this.connectedUser, tweet:this.tweetProp.id
                    }
                }).then(response => {
                  this.$emit('retweeted', this.tweetProp.id)
                }, response => {
                  // error callback
                });
      },
      canRetweet: function () {
        console.log(this.tweetProp.retweeters, this.connectedUser);
        var exist = this.tweetProp.retweeters.find(e => e.handle === this.connectedUser);
        var auteur = this.tweetProp.auteur.handle === this.connectedUser;
        if (exist || auteur) return false;
        else return true;
      }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
li.button {
 display: inline-block;
}

a {
 color: #42b983;
}

span.handle {
 color: gray;
}
</style>
