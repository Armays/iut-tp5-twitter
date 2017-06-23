
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
        <li class="button">
          <icon name="retweet"/>{{tweetProp.retweeters.length}}
        </li>
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

export default {
  name: 'TweetComp',
  props: ['tweetProp'],
  components: { Icon },
  methods: {
      momentf: function (date) {
        return moment(date)
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
