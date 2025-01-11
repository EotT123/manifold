/*
 * Copyright (c) 2018 - Manifold Systems LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package manifold.api.gen;

import java.util.List;

/**
 */
public class SrcParameter extends SrcAnnotated<SrcParameter>
{
  private SrcType _type;
  private SrcExpression _initializer;

  public SrcParameter( String name )
  {
    name( name );
  }

  public SrcParameter( String name, Class type )
  {
    name( name );
    type( type );
  }

  public SrcParameter( String name, String type )
  {
    name( name );
    type( type );
  }

  public SrcParameter( String name, SrcType type )
  {
    name( name );
    type( type );
  }

  public SrcParameter( String name, SrcType type, SrcExpression initializer )
  {
    name( name );
    type( type );
    initializer( initializer );
  }

  public SrcParameter initializer( SrcExpression expr )
  {
    _initializer = expr;
    return this;
  }

  public SrcParameter type( SrcType type )
  {
    _type = type;
    return this;
  }

  public SrcParameter type( Class type )
  {
    _type = new SrcType( type );
    return this;
  }

  public SrcParameter type( String type )
  {
    _type = new SrcType( type );
    return this;
  }

  public SrcType getType()
  {
    return _type;
  }

  @Override
  public StringBuilder render( StringBuilder sb, int indent )
  {
    return render( sb, indent, false );
  }
  public StringBuilder render( StringBuilder sb, int indent, boolean varArgs )
  {
    return render( sb, indent, varArgs, false );
  }
  public StringBuilder render( StringBuilder sb, int indent, boolean varArgs, boolean forSignature )
  {
    if( !forSignature )
    {
      SrcType paramType = varArgs ? _type.getComponentType() : _type;
      List<SrcAnnotationExpression> paramTypeAnnos = paramType.getAnnotations();

      renderAnnotations( sb, 0, true, paramTypeAnnos ); // don't duplicate annos on the param _type_
      renderModifiers( sb, false, 0 );
    }
    if( varArgs )
    {
      _type.getComponentType().render( sb, 0 ).append( "..." );
    }
    else
    {
      _type.render( sb, 0 );
    }
    if( !forSignature )
    {
      sb.append( ' ' ).append( getSimpleName() );
    }

    if( _initializer != null )
    {
      sb.append( " = " );
      _initializer.render( sb, 0 );
    }
    return sb;
  }
}
