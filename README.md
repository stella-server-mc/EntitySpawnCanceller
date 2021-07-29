# EntitySpawnCanceller

設定したエンティティのスポーンをキャンセルするプラグイン

## コマンド
`/esc setMode [true/false]` エンティティのスポーンをキャンセルする機能実行をtrue(有効化)、false(無効化)で設定する。
`/esc addEntity <EntityType>` : スポーンをキャンセルするエンティティを追加する。<br>
`/esc removeEntity <EntityType>` : スポーンをキャンセルするエンティティを削除する。<br>
`/esc reload` : このプラグインのコンフィグを再読み込みする。<br>

## コンフィグ
pluginsディレクトリに生成された`config.yml`を開き、SpawnCancelEntitiesに以下の方法でスポーンをキャンセルしたいエンティティを設定する。
1. [org.bukkit.org/bukkit/entity/EntityType](https://papermc.io/javadocs/paper/1.13/org/bukkit/entity/EntityType.html)よりエンティティを見つける。
2. エンティティ名を**大文字のまま**記憶する。
3. `config.yml`の`SpawnCancelEntities`に配列で2で記憶したエンティティ名を設定する。

## 依存
なし

## 提供先
StellaServer 2021/07/30

## 作者
[huda0209](https://github.com/huda0209)
