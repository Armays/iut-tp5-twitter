<template>
  <div class="timeline">
  <ul>
    <li v-for="tweet in tweets">
      <tweet-comp :tweetProp="tweet"></tweet-comp>
    </li>
  </ul>
  </div>
</template>

<script>
import TweetComp from './TweetComp'
export default {
  name: 'timeline',
  data () {
            return {
                     tweets: [
                        {
                          auteur: 'Dianounette',
                          contenu: 'La vie c\'est trop cool !'
                        },
                        {
                          auteur: 'Yoann',
                          contenu: 'La vie c\'est trop de la merde !'
                        },
                        {
                          auteur: 'Fanny',
                          contenu: 'La bière c\'est trop cool mais seulement grâce à la bière !'
                        }
                     ]
                   }
          },
    components: {TweetComp}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: block;
  margin: 0 10px;
}
</style>
